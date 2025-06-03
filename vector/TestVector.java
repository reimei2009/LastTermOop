package hus.oop.vector;

import java.util.Random;
import java.io.PrintWriter;
import java.io.File;

public class TestVector {
    private MyVector vector;

    public TestVector(MyVector vector) {
        this.vector = vector;
    }

    public static void main(String[] args) {
        /* TODO
           - Thực hiện các hàm test.
           - Lưu các kết quả chạy chương trình vào file text có tên <Ten_MaSinhVien_Vector>.txt
             (ví dụ NguyenVanA_123456_Vector.txt). Nén các file source code và file kết quả vào file zip có tên
             <Ten_MaSinhVien_Vector>.zip (ví dụ NguyenVanA_123456_Vector.zip), nộp lên classroom.
         */
        try {
            PrintWriter writer = new PrintWriter(new File("NguyenVanA_123456_Vector.txt"));

            writer.println("Testing MyArrayVector:");
            TestVector arrayTest = new TestVector(new MyArrayVector());
            arrayTest.testArrayVector(writer);

            writer.println("\nTesting MyListVector:");
            TestVector listTest = new TestVector(new MyListVector());
            listTest.testListVector(writer);

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testArrayVector() {
        /* TODO
         - Sinh ngẫu nhiên một số tự nhiên, lưu giá trị sinh ra vào biến n.
         - Tạo ra vector có kích thước n, với các phần tử được sinh ngẫu nhiên, lưu vào biến vector, sử dụng MyArrayVector.
         - Viết các các chứ năng của các vector, như thêm vào phần tử, xóa bớt phần tử, sửa giá trị các
           phần tử, cộng các vector, nhân vector với vô hướng, tích vô hướng 2 vector, chuẩn vector, ... Mỗi lần thay
           đổi vector hoặc tính toán, in các kết quả ra terminal.
         */
    }

    public void testArrayVector(PrintWriter writer) {
        Random rand = new Random();
        int n = rand.nextInt(6) + 8; // Size between 8 and 13

        for (int i = 0; i < n; i++) {
            vector.insert(Math.round(rand.nextDouble() * 10 + 5) * 10 / 10.0); // [5, 15], rounded
        }
        writer.println("Start: " + vector);

        writer.println("Norm: " + vector.norm());

        MyVector another = new MyArrayVector();
        for (int i = 0; i < vector.size(); i++) {
            another.insert(Math.round(rand.nextDouble() * 5 + 2) * 10 / 10.0); // [2, 7]
        }
        writer.println("Other: " + another);
        writer.println("Dot: " + vector.dot(another));

        writer.println("Equal: " + vector.equals(another));

        vector.scale(2.0);
        writer.println("Scaled x2: " + vector);

        vector.pow(2.0);
        writer.println("Squared: " + vector);

        MyVector sub = vector.minus(3.0);
        writer.println("Minus 3: " + sub);

        vector.addTo(1.5);
        writer.println("Added 1.5: " + vector);

        MyVector addVec = vector.add(another);
        writer.println("Added vec: " + addVec);

        MyVector addScalar = vector.add(1.0);
        writer.println("Added 1: " + addScalar);

        vector.set(7.0, 0);
        writer.println("Set 1st to 7: " + vector);

        vector.remove(0);
        writer.println("Removed 1st: " + vector);

        vector.insert(5.5, 0);
        writer.println("Inserted 5.5 at 0: " + vector);

        vector.insert(6.5);
        writer.println("Inserted 6.5: " + vector);

        int[] indices = {0, vector.size() - 1};
        MyVector ext = vector.extract(indices);
        writer.println("Extracted [0, last]: " + ext);
    }

    public void testListVector() {
        /* TODO
         - Sinh ngẫu nhiên một số tự nhiên, lưu giá trị sinh ra vào biến n.
         - Tạo ra vector có kích thước n, với các phần tử được sinh ngẫu nhiên, lưu vào biến vector, sử dụng MyListVector.
         - Viết các các chứ năng của các vector, như thêm vào phần tử, xóa bớt phần tử, sửa giá trị các
           phần tử, cộng các vector, nhân vector với vô hướng, tích vô hướng 2 vector, chuẩn vector, ... Mỗi lần thay
           đổi vector hoặc tính toán, in các kết quả ra terminal.
         */
    }

    public void testListVector(PrintWriter writer) {
        Random rand = new Random();
        int n = rand.nextInt(6) + 8; // Size between 8 and 13

        for (int i = 0; i < n; i++) {
            vector.insert(Math.round(rand.nextDouble() * 10 + 5) * 10 / 10.0); // [5, 15], rounded
        }
        writer.println("Start: " + vector);

        writer.println("Norm: " + vector.norm());

        MyVector another = new MyListVector();
        for (int i = 0; i < vector.size(); i++) {
            another.insert(Math.round(rand.nextDouble() * 5 + 2) * 10 / 10.0); // [2, 7]
        }
        writer.println("Other: " + another);
        writer.println("Dot: " + vector.dot(another));

        writer.println("Equal: " + vector.equals(another));

        vector.scale(2.0);
        writer.println("Scaled x2: " + vector);

        vector.pow(2.0);
        writer.println("Squared: " + vector);

        MyVector sub = vector.minus(3.0);
        writer.println("Minus 3: " + sub);

        vector.addTo(1.5);
        writer.println("Added 1.5: " + vector);

        MyVector addVec = vector.add(another);
        writer.println("Added vec: " + addVec);

        MyVector addScalar = vector.add(1.0);
        writer.println("Added 1: " + addScalar);

        vector.set(7.0, 0);
        writer.println("Set 1st to 7: " + vector);

        vector.remove(0);
        writer.println("Removed 1st: " + vector);

        vector.insert(5.5, 0);
        writer.println("Inserted 5.5 at 0: " + vector);

        vector.insert(6.5);
        writer.println("Inserted 6.5: " + vector);

        int[] indices = {0, vector.size() - 1};
        MyVector ext = vector.extract(indices);
        writer.println("Extracted [0, last]: " + ext);
    }
}