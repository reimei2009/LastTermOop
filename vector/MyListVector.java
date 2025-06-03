package hus.oop.vector;

import java.util.List;
import java.util.ArrayList;

public class MyListVector extends MyAbstractVector {
    private List<Double> data;

    /**
     * Khởi tạo mặc định cho vector.
     */
    public MyListVector() {
        data = new ArrayList<>();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public double coordinate(int index) {
        if (index < 0 || index >= data.size()) throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + data.size());
        return data.get(index);
    }

    @Override
    public double[] coordinates() {
        double[] result = new double[data.size()];
        for (int i = 0; i < data.size(); i++) result[i] = data.get(i);
        return result;
    }

    @Override
    public MyListVector insert(double value) {
        if (Double.isNaN(value) || Double.isInfinite(value)) throw new IllegalArgumentException("Value must be finite and not NaN");
        data.add(value);
        return this;
    }

    @Override
    public MyListVector insert(double value, int index) {
        if (index < 0 || index > data.size()) throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + data.size());
        if (Double.isNaN(value) || Double.isInfinite(value)) throw new IllegalArgumentException("Value must be finite and not NaN");
        data.add(index, value);
        return this;
    }

    @Override
    public MyListVector remove(int index) {
        if (index < 0 || index >= data.size()) throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + data.size());
        data.remove(index);
        return this;
    }

    @Override
    public MyListVector extract(int[] indices) {
        if (indices == null) throw new IllegalArgumentException("Indices array cannot be null");
        MyListVector sorted = sortIncreasing();
        MyListVector result = new MyListVector();
        for (int index : indices) {
            int pos = sorted.binarySearch(sorted.data.get(index));
            if (pos != -1) result.insert(sorted.data.get(pos));
        }
        return result;
    }

    @Override
    public void set(double value, int index) {
        if (index < 0 || index >= data.size()) throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + data.size());
        if (Double.isNaN(value) || Double.isInfinite(value)) throw new IllegalArgumentException("Value must be finite and not NaN");
        data.set(index, value);
    }

    @Override
    public MyListVector add(double value) {
        MyListVector result = new MyListVector();
        for (Double d : data) result.insert(d + value);
        return result;
    }

    @Override
    public MyListVector add(MyVector another) {
        if (this.size() != another.size()) throw new IllegalArgumentException("Vectors must have the same size");
        MyListVector result = new MyListVector();
        for (int i = 0; i < data.size(); i++) result.insert(data.get(i) + another.coordinate(i));
        return result;
    }

    @Override
    public MyListVector addTo(double value) {
        for (int i = 0; i < data.size(); i++) data.set(i, data.get(i) + value);
        return this;
    }

    @Override
    public MyListVector addTo(MyVector another) {
        if (this.size() != another.size()) throw new IllegalArgumentException("Vectors must have the same size");
        for (int i = 0; i < data.size(); i++) data.set(i, data.get(i) + another.coordinate(i));
        return this;
    }

    @Override
    public MyListVector minus(double value) {
        MyListVector result = new MyListVector();
        for (Double d : data) result.insert(d - value);
        return result;
    }

    @Override
    public MyListVector minus(MyVector another) {
        if (this.size() != another.size()) throw new IllegalArgumentException("Vectors must have the same size");
        MyListVector result = new MyListVector();
        for (int i = 0; i < data.size(); i++) result.insert(data.get(i) - another.coordinate(i));
        return result;
    }

    @Override
    public MyListVector minusFrom(double value) {
        for (int i = 0; i < data.size(); i++) data.set(i, value - data.get(i));
        return this;
    }

    @Override
    public MyListVector minusFrom(MyVector another) {
        if (this.size() != another.size()) throw new IllegalArgumentException("Vectors must have the same size");
        for (int i = 0; i < data.size(); i++) data.set(i, another.coordinate(i) - data.get(i));
        return this;
    }

    @Override
    public double dot(MyVector another) {
        if (this.size() != another.size()) throw new IllegalArgumentException("Vectors must have the same size");
        double result = 0;
        java.util.Iterator<Double> it = data.iterator();
        int index = 0;
        while (it.hasNext()) result += it.next() * another.coordinate(index++);
        return result;
    }

    @Override
    public MyListVector pow(double power) {
        for (int i = 0; i < data.size(); i++) data.set(i, Math.pow(data.get(i), power));
        return this;
    }

    @Override
    public MyListVector scale(double value) {
        for (int i = 0; i < data.size(); i++) data.set(i, data.get(i) * value);
        return this;
    }

    @Override
    public double norm() {
        double result = 0;
        for (Double d : data) result = Math.hypot(result, d);
        return result;
    }

    private MyListVector sortIncreasing() {
        MyListVector sorted = new MyListVector();
        for (Double d : data) sorted.insert(d);
        java.util.Collections.sort(sorted.data);
        return sorted;
    }

    private int binarySearch(double value) {
        int left = 0, right = data.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (data.get(mid) == value) return mid;
            if (data.get(mid) < value) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}