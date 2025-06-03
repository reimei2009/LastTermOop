package hus.oop.statistics;

public class MyArrayList extends MyAbstractList {
    private static final int DEFAULT_CAPACITY = 16;
    private double[] data;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyArrayList() {
        data = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(double data) {
        if (size == this.data.length) {
            allocateMore();
        }
        this.data[size++] = data;
    }

    @Override
    public void insert(double data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        if (size == this.data.length) {
            allocateMore();
        }
        for (int i = size; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[index] = data;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        for (int i = index; i < size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        size--;
    }

    @Override
    public MyArrayList sortIncreasing() {
        MyArrayList sorted = new MyArrayList();
        for (int i = 0; i < size; i++) {
            sorted.add(this.data[i]);
        }
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

    @Override
    public int binarySearch(double data) {
        MyArrayList sorted = sortIncreasing();
        int left = 0;
        int right = sorted.size - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sorted.data[mid] == data) {
                while (mid > 0 && sorted.data[mid - 1] == data) mid--;
                return mid;
            }
            if (sorted.data[mid] < data) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Tạo iterator để có thể duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator(int start) {
        return new MyArrayListIterator(start);
    }

    /**
     * Cấp phát gấp đôi chỗ cho danh sách khi cần thiết.
     */
    private void allocateMore() {
        double[] newData = new double[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    private class MyArrayListIterator implements MyIterator {
        /**
         * Vị trí hiện tại của iterator trong MyArrayList.
         */
        private int currentPosition;

        /**
         * Khởi tạo dữ liệu cho iterator tại vị trí position của list.
         */
        public MyArrayListIterator(int position) {
            if (position < 0 || position >= size) {
                throw new IndexOutOfBoundsException("Position " + position + " out of bounds for size " + size);
            }
            currentPosition = position;
        }

        @Override
        public boolean hasNext() {
            return currentPosition < size - 1;
        }

        @Override
        public Number next() {
            if (!hasNext() && currentPosition >= size) {
                throw new IndexOutOfBoundsException("No next element at position " + currentPosition);
            }
            return data[currentPosition++];
        }

        @Override
        public void remove() {
            if (currentPosition <= 0 || currentPosition > size) {
                throw new IllegalStateException("Cannot remove at position " + currentPosition);
            }
            MyArrayList.this.remove(currentPosition - 1);
            currentPosition--;
        }
    }
}