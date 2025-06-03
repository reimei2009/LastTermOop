package hus.oop.fraction;

public class MyArrayDataSet implements MyDataSet {
    private static int DEFAULT_CAPACITY = 16;
    private MyFraction[] fractions;
    private int length;

    /**
     * Hàm dựng khởi tạo mảng chứa các phân số có kích thước là DEFAULT_CAPACITY.
     */
    public MyArrayDataSet() {
        fractions = new MyFraction[DEFAULT_CAPACITY];
        length = 0;
    }

    /**
     * Hàm dựng khởi tạo mảng chứa các phân số truyền vào.
     * @param fractions
     */
    public MyArrayDataSet(MyFraction[] fractions) {
        if (fractions == null) {
            this.fractions = new MyFraction[DEFAULT_CAPACITY];
            length = 0;
        } else {
            this.fractions = new MyFraction[Math.max(fractions.length, DEFAULT_CAPACITY)];
            length = 0;
            for (int i = 0; i < fractions.length; i++) {
                if (fractions[i] != null) {
                    this.fractions[length] = new MyFraction(fractions[i]);
                    length++;
                }
            }
        }
    }

    /**
     * Phương thức chèn phân số fraction vào vị trí index.
     * Nếu index nằm ngoài đoạn [0, length] thì không chèn được vào.
     * Nếu mảng hết chỗ để thêm dữ liệu, mở rộng kích thước mảng gấp đôi.
     * @param fraction là một phân số.
     * @return true nếu chèn được số vào, false nếu không chèn được số vào.
     */
    @Override
    public boolean insert(MyFraction fraction, int index) {
        if (index < 0 || index > length || fraction == null) return false;
        if (length == fractions.length) {
            MyFraction[] temp = new MyFraction[fractions.length * 2];
            for (int i = 0; i < length; i++) temp[i] = fractions[i];
            fractions = temp;
        }
        for (int i = length; i > index; i--) fractions[i] = fractions[i - 1];
        fractions[index] = new MyFraction(fraction);
        length++;
        return true;
    }

    /**
     * Phương thức thêm phân số fraction vào vị trí cuối cùng chưa có dứ liệu của mảng data.
     * Nếu mảng hết chỗ để thêm dữ liệu, mở rộng kích thước mảng gấp đôi.
     * @param fraction
     * @return true nếu chèn được số vào, false nếu không chèn được số vào.
     */
    @Override
    public boolean append(MyFraction fraction) {
        if (fraction == null) return false;
        return insert(fraction, length);
    }

    @Override
    public MyArrayDataSet toSimplify() {
        MyArrayDataSet simplified = new MyArrayDataSet();
        for (int i = length - 1; i >= 0; i--) {
            MyFraction fraction = new MyFraction(fractions[i]);
            fraction.simplify();
            simplified.append(fraction);
        }
        return simplified;
    }

    @Override
    public MyArrayDataSet sortIncreasing() {
        MyArrayDataSet sorted = new MyArrayDataSet();
        for (int i = 0; i < length; i++) sorted.append(new MyFraction(fractions[i]));
        quickSort(sorted.fractions, 0, sorted.length - 1);
        return sorted;
    }

    @Override
    public MyArrayDataSet sortDecreasing() {
        MyArrayDataSet sorted = new MyArrayDataSet();
        for (int i = 0; i < length; i++) sorted.append(new MyFraction(fractions[i]));
        mergeSort(sorted.fractions, 0, sorted.length - 1);
        return sorted;
    }

    @Override
    public String myDataSetToString() {
        return "[" + String.join(", ", java.util.Arrays.stream(fractions, 0, length).map(f -> f == null ? "" : f.toString()).toArray(String[]::new)) + "]";
    }

    @Override
    public void print() {
        System.out.println(myDataSetToString());
    }

    /**
     * Phương thức mở rộng kích thước mảng gấp đôi, bằng cách tạo ra mảng mới có kích thước
     * gấp đôi, sau đó copy dự liệu từ mảng cũ vào.
     */
    private void allocateMore() {
        MyFraction[] newFractions = new MyFraction[fractions.length * 2];
        System.arraycopy(fractions, 0, newFractions, 0, fractions.length);
        fractions = newFractions;
    }

    /**
     * Phương thức kiểm tra xem index có nằm trong khoảng [0, upperBound] hay không.
     * @param index
     * @param upperBound
     * @return true nếu index nằm trong khoảng [0, upperBound], false nếu ngược lại.
     */
    private boolean checkBoundaries(int index, int upperBound) {
        return index >= 0 && index <= upperBound;
    }

    private void quickSort(MyFraction[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(MyFraction[] arr, int low, int high) {
        MyFraction pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                MyFraction temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } else if (arr[j].compareTo(pivot) == 0) {
                if (arr[j].getDenominator() < pivot.getDenominator()) {
                    i++;
                    MyFraction temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        MyFraction temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    private void mergeSort(MyFraction[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private void merge(MyFraction[] arr, int l, int m, int r) {
        MyFraction[] left = new MyFraction[m - l + 1];
        MyFraction[] right = new MyFraction[r - m];
        for (int i = 0; i < left.length; i++) left[i] = arr[l + i];
        for (int j = 0; j < right.length; j++) right[j] = arr[m + 1 + j];
        int i = 0, j = 0, k = l;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) >= 0) {
                arr[k++] = left[i++];
            } else if (left[i].compareTo(right[j]) == 0 && left[i].getDenominator() >= right[j].getDenominator()) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }
}