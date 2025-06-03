package hus.oop.fraction;

public interface MyDataSet {
    /**
     * Phương thức chèn phân số fraction vào vị trí index.
     * @param fraction là một phân số.
     * @return true nếu chèn được số vào, false nếu không chèn được số vào.
     */
    boolean insert(MyFraction fraction, int index);

    /**
     * Phương thức thêm phân số fraction vào vị trí cuối cùng danh sách.
     * @param fraction
     * @return true nếu chèn được số vào, false nếu không chèn được số vào.
     */
    boolean append(MyFraction fraction);

    /**
     * Phương thức tạo ra một tập dữ liệu lưu các phân số tối giản của các phân số trong tập dữ liệu gốc.
     * @return tập dữ liệu mới lưu các phân số tối giản của các phân số trong tập dữ liệu gốc.
     */
    MyDataSet toSimplify();

    /**
     * Sắp xếp mảng các phân số theo thứ tự có giá trị tăng dần.
     * Nếu hai phân số bằng nhau thì sắp xếp theo thứ tự có mẫu số tăng dần.
     * @return mảng mới được sắp xếp theo thứ tự có giá trị tăng dần.
     */
    MyDataSet sortIncreasing();

    /**
     * Sắp xếp mảng các phân số theo thứ tự có giá trị giảm dần.
     * Nếu hai phân số bằng nhau thì sắp xếp theo thứ tự có mẫu số giảm dần.
     * @return mảng mới được sắp xếp theo thứ tự có giá trị giảm dần.
     */
    MyDataSet sortDecreasing();

    /**
     * In ra tập dữ liệu theo định dạng [a1, a2, ... , an].
     * @return
     */
    String myDataSetToString();

    /**
     * In ra các phân số fractions theo định dạng [a1, a2, ... , an].
     */
    void print();
}
