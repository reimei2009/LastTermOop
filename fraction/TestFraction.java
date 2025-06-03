package hus.oop.fraction;

import java.util.Random;
import java.io.PrintWriter;
import java.io.File;

public class TestFraction {
    private MyDataSet myDataSet;

    public TestFraction(MyDataSet myDataSet) {
        this.myDataSet = myDataSet;
    }

    public static void main(String[] args) {
        /* TODO:
         - Viết code cho các hàm test.
         - Chạy chương trình và lưu kết quả chạy chương trình và file text được đặt tên
           là <TenSinhVien_MaSinhVien_MyFractions>.txt (Ví dụ, NguyenVanA_123456_MyFractions.txt).
         - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
           <TenSinhVien_MaSinhVien_MyFractions>.zip (Ví dụ, NguyenVanA_123456_MyFractions.zip),
           nộp lên classroom.
         */
        try {
            PrintWriter writer = new PrintWriter(new File("NguyenVanA_123456_MyFractions.txt"));

            TestFraction arrayTest = new TestFraction(new MyArrayDataSet());
            writer.println("Testing MyArrayDataSet:");
            arrayTest.testMyArrayDataSet(writer);

            writer.println("\nTesting MyListDataSet:");
            TestFraction listTest = new TestFraction(new MyListDataSet());
            listTest.testMyListDataSet(writer);

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testMyArrayDataSet() {
        /* TODO
        1. Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu giá trị vào biến numbers.
        2. Tạo ra numbers phân số, trong đó tử số và mẫu số được sinh ngẫu nhiên là các số tự nhiên nằm trong đoạn [1, 100].
           Lưu các phân số vào trong một tập dữ liệu myDataSet dùng MyArrayDataSet.

        3. Sắp xếp và in ra tập dữ liệu đã tạo ra theo các tiêu chí sau:
             - In ra các phân số theo thứ tự có giá trị tăng dần, nếu phân số bằng nhau thì được sắp xếp theo thứ tự
               có giá trị tăng dần của mẫu số.
             - In ra các phân số theo thứ tự có giá trị giảm dần, nếu phân số bằng nhau thì được sắp xếp theo thứ tự
               có giá trị giảm dần của mẫu số.

         4. In ra các dữ liệu sau:
             - In ra các phân số tối giản của các phân số đã tạo ra theo thứ tự trong dữ liệu gốc.
             - In ra các phân số tối giản theo thứ tự tăng dần.
             - In ra các phân số tối giản theo thứ tự giảm dần.
        */
    }

    public void testMyArrayDataSet(PrintWriter writer) {
        Random rand = new Random();
        int numbers = rand.nextInt(21) + 30; // [30, 50]

        for (int i = 0; i < numbers; i++) {
            int numerator = rand.nextInt(100) + 1; // [1, 100]
            int denominator = rand.nextInt(100) + 1; // [1, 100]
            myDataSet.append(new MyFraction(numerator, denominator));
        }

        writer.println("Count: " + numbers);
        writer.println("Original: " + myDataSet.myDataSetToString());

        // In các phân số gốc theo thứ tự tăng/giảm dần
        MyDataSet sortedIncreasing = myDataSet.sortIncreasing();
        writer.println("Original sorted increasing: " + sortedIncreasing.myDataSetToString());

        MyDataSet sortedDecreasing = myDataSet.sortDecreasing();
        writer.println("Original sorted decreasing: " + sortedDecreasing.myDataSetToString());

        // In các phân số tối giản
        MyDataSet simplified = myDataSet.toSimplify();
        writer.println("Simplified: " + simplified.myDataSetToString());

        MyDataSet simplifiedIncreasing = simplified.sortIncreasing();
        writer.println("Simplified increasing: " + simplifiedIncreasing.myDataSetToString());

        MyDataSet simplifiedDecreasing = simplified.sortDecreasing();
        writer.println("Simplified decreasing: " + simplifiedDecreasing.myDataSetToString());
    }

    public void testMyListDataSet() {
        /* TODO
        1. Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu giá trị vào biến numbers.
        2. Tạo ra numbers phân số, trong đó tử số và mẫu số được sinh ngẫu nhiên là các số tự nhiên nằm trong đoạn [1, 100].
           Lưu các phân số vào trong một tập dữ liệu myDataSet dùng MyListDataSet.

        3. Sắp xếp và in ra tập dữ liệu đã tạo ra theo các tiêu chí sau:
             - In ra các phân số theo thứ tự có giá trị tăng dần, nếu phân số bằng nhau thì được sắp xếp theo thứ tự
               có giá trị tăng dần của mẫu số.
             - In ra các phân số theo thứ tự có giá trị giảm dần, nếu phân số bằng nhau thì được sắp xếp theo thứ tự
               có giá trị giảm dần của mẫu số.

         4. In ra các dữ liệu sau:
             - In ra các phân số tối giản của các phân số đã tạo ra theo thứ tự trong dữ liệu gốc.
             - In ra các phân số tối giản theo thứ tự tăng dần.
             - In ra các phân số tối giản theo thứ tự giảm dần.
        */
    }

    public void testMyListDataSet(PrintWriter writer) {
        Random rand = new Random();
        int numbers = rand.nextInt(21) + 30; // [30, 50]

        for (int i = 0; i < numbers; i++) {
            int numerator = rand.nextInt(100) + 1; // [1, 100]
            int denominator = rand.nextInt(100) + 1; // [1, 100]
            myDataSet.append(new MyFraction(numerator, denominator));
        }

        writer.println("Count: " + numbers);
        writer.println("Original: " + myDataSet.myDataSetToString());

        // In các phân số gốc theo thứ tự tăng/giảm dần
        MyDataSet sortedIncreasing = myDataSet.sortIncreasing();
        writer.println("Original sorted increasing: " + sortedIncreasing.myDataSetToString());

        MyDataSet sortedDecreasing = myDataSet.sortDecreasing();
        writer.println("Original sorted decreasing: " + sortedDecreasing.myDataSetToString());

        // In các phân số tối giản
        MyDataSet simplified = myDataSet.toSimplify();
        writer.println("Simplified: " + simplified.myDataSetToString());

        MyDataSet simplifiedIncreasing = simplified.sortIncreasing();
        writer.println("Simplified increasing: " + simplifiedIncreasing.myDataSetToString());

        MyDataSet simplifiedDecreasing = simplified.sortDecreasing();
        writer.println("Simplified decreasing: " + simplifiedDecreasing.myDataSetToString());
    }
}