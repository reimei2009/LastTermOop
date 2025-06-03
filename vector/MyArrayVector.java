package hus.oop.vector;

public class MyArrayVector extends MyAbstractVector {
    private static final int DEFAULT_CAPACITY = 16;
    private double[] data;
    private int size;

    /**
     * Khởi tạo mặc định cho vector.
     */
    public MyArrayVector() {
        data = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public double coordinate(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        return data[index];
    }

    @Override
    public double[] coordinates() {
        double[] result = new double[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }

    @Override
    public MyArrayVector insert(double value) {
        if (Double.isNaN(value) || Double.isInfinite(value)) throw new IllegalArgumentException("Value must be finite and not NaN");
        if (size == data.length) allocateMore();
        data[size++] = value;
        return this;
    }

    @Override
    public MyArrayVector insert(double value, int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        if (Double.isNaN(value) || Double.isInfinite(value)) throw new IllegalArgumentException("Value must be finite and not NaN");
        if (size == data.length) allocateMore();
        for (int i = size; i > index; i--) data[i] = data[i - 1];
        data[index] = value;
        size++;
        return this;
    }

    @Override
    public MyArrayVector remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        for (int i = index; i < size - 1; i++) data[i] = data[i + 1];
        size--;
        return this;
    }

    @Override
    public MyArrayVector extract(int[] indices) {
        if (indices == null) throw new IllegalArgumentException();
        MyArrayVector sorted = sortIncreasing();
        MyArrayVector result = new MyArrayVector();
        for (int index : indices) {
            int pos = sorted.binarySearch(sorted.data[index]);
            if (pos != -1) result.insert(sorted.data[pos]);
        }
        return result;
    }

    @Override
    public void set(double value, int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        if (Double.isNaN(value) || Double.isInfinite(value)) throw new IllegalArgumentException("Value must be finite and not NaN");
        data[index] = value;
    }

    @Override
    public MyArrayVector add(double value) {
        double[] newData = new double[size];
        for (int i = 0; i < size; i++) newData[i] = data[i] + value;
        MyArrayVector result = new MyArrayVector();
        for (double v : newData) result.insert(v);
        return result;
    }

    @Override
    public MyArrayVector add(MyVector another) {
        if (this.size() != another.size()) throw new IllegalArgumentException("Vectors must have the same size");
        double[] newData = new double[size];
        for (int i = 0; i < size; i++) newData[i] = data[i] + another.coordinate(i);
        MyArrayVector result = new MyArrayVector();
        for (double v : newData) result.insert(v);
        return result;
    }

    @Override
    public MyArrayVector addTo(double value) {
        for (int i = 0; i < size; i++) data[i] += value;
        return this;
    }

    @Override
    public MyArrayVector addTo(MyVector another) {
        if (this.size() != another.size()) throw new IllegalArgumentException("Vectors must have the same size");
        for (int i = 0; i < size; i++) data[i] += another.coordinate(i);
        return this;
    }

    @Override
    public MyArrayVector minus(double value) {
        double[] newData = new double[size];
        for (int i = 0; i < size; i++) newData[i] = data[i] - value;
        MyArrayVector result = new MyArrayVector();
        for (double v : newData) result.insert(v);
        return result;
    }

    @Override
    public MyArrayVector minus(MyVector another) {
        if (this.size() != another.size()) throw new IllegalArgumentException("Need same size.");
        double[] newData = new double[size];
        for (int i = 0; i < size; i++) newData[i] = data[i] - another.coordinate(i);
        MyArrayVector result = new MyArrayVector();
        for (double v : newData) result.insert(v);
        return result;
    }

    @Override
    public MyArrayVector minusFrom(double value) {
        for (int i = 0; i < size; i++) data[i] = value - data[i];
        return this;
    }

    @Override
    public MyArrayVector minusFrom(MyVector another) {
        if (this.size() != another.size()) throw new IllegalArgumentException("Need same size.");
        for (int i = 0; i < size; i++) data[i] = another.coordinate(i) - data[i];
        return this;
    }

    @Override
    public double dot(MyVector another) {
        if (this.size() != another.size()) throw new IllegalArgumentException("Need same size.");
        double result = 0;
        for (int i = size - 1; i >= 0; i--) result += data[i] * another.coordinate(i);
        return result;
    }

    @Override
    public MyArrayVector pow(double power) {
        for (int i = 0; i < size; i++) data[i] = Math.pow(data[i], power);
        return this;
    }

    @Override
    public MyArrayVector scale(double value) {
        for (int i = 0; i < size; i++) data[i] *= value;
        return this;
    }

    @Override
    public double norm() {
        double result = 0;
        for (int i = 0; i < size; i++) result = Math.hypot(result, data[i]);
        return result;
    }

    /**
     * Mở rộng kích thước vector lên gấp đôi khi cần thiết.
     */
    private void allocateMore() {
        double[] newData = new double[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    private MyArrayVector sortIncreasing() {
        MyArrayVector sorted = new MyArrayVector();
        for (int i = 0; i < size; i++) sorted.insert(data[i]);
        for (int i = 1; i < sorted.size; i++) {
            double key = sorted.data[i];
            int j = i - 1;
            while (j >= 0 && sorted.data[j] > key) {
                sorted.data[j + 1] = sorted.data[j];
                j--;
            }
            sorted.data[j + 1] = key;
        }
        return sorted;
    }

    private int binarySearch(double value) {
        int left = 0, right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (data[mid] == value) return mid;
            if (data[mid] < value) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}