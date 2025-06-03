package hus.oop.vector;

public abstract class MyAbstractVector implements MyVector {
    /**
     * Mô tả vector theo định dạng [a1 a2 ... an]
     * @return
     */
    @Override
    public String toString() {
        double[] coords = coordinates();
        String[] elements = new String[coords.length];
        for (int i = 0; i < coords.length; i++) {
            elements[i] = String.valueOf(coords[i]);
        }
        return "[" + String.join(" ", elements) + "]";
    }

    /**
     * So sánh hai vector có bằng nhau không.
     * Hai vector bằng nhau nếu có cùng kích thước và có các phần tử bằng nhau.
     * @param another
     * @return
     */
    @Override
    public boolean equals(MyVector another) {
        if (this.size() != another.size()) return false;
        double[] thisCoords = this.coordinates();
        double[] otherCoords = another.coordinates();
        for (int i = this.size() - 1; i >= 0; i--) {
            if (thisCoords[i] != otherCoords[i]) return false;
        }
        return true;
    }
}