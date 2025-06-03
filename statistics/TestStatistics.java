package hus.oop.statistics;

import java.util.Random;
import java.io.PrintWriter;
import java.io.File;

public class TestStatistics {
    private Statistics statistics;

    public TestStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public static void main(String[] args) {
        /* TODO
           - Thực hiện từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
             là <TenSinhVien_MaSinhVien_Statistics>.txt (Ví dụ, NguyenVanA_123456_Statistics.txt).
           - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
             <TenSinhVien_MaSinhVien_Statistics>.zip (Ví dụ, NguyenVanA_123456_Statistics.zip),
             nộp lên classroom.
         */
        try {
            PrintWriter writer = new PrintWriter(new File("NguyenVanA_123456_Statistics.txt"));

            writer.println("Testing MyArrayList:");
            TestStatistics arrayTest = new TestStatistics(new Statistics(new MyArrayList()));
            arrayTest.testMyArrayList(writer);

            writer.println("\nTesting MyLinkedList:");
            TestStatistics linkedTest = new TestStatistics(new Statistics(new MyLinkedList()));
            linkedTest.testMyLinkedList(writer);

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testMyArrayList() {
        /* TODO
           - Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu vào biến length.
           - Tạo một list kiểu MyArrayList, có các phần tử dữ liệu kiểu double được sinh ngẫu nhiên
             nằm trong đoạn [1, 20]. Tạo Statistics có dữ liệu là list dữ liệu vừa tạo, lưu vào statistics.
           - Sử dụng Statistics để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai, rank, sắp xếp, tìm kiếm).
             In ra terminal tập dữ liệu, tập dữ liệu được sắp xếp, các đại lượng thống kê và kết quả chức năng tìm kiếm.
         */
    }

    public void testMyArrayList(PrintWriter writer) {
        Random rand = new Random();
        int length = rand.nextInt(21) + 30; // [30, 50]

        MyArrayList list = new MyArrayList();
        for (int i = 0; i < length; i++) {
            double value = Math.round((rand.nextDouble() * 15 + 5) * 10) / 10.0; // [5, 20], làm tròn 1 chữ số thập phân
            list.add(value);
        }
        statistics = new Statistics(list);

        writer.println("Statistics Summary:");
        writer.printf("Mean: %.2f%n", statistics.mean());
        writer.printf("Variance: %.2f%n", statistics.variance());
        writer.printf("Max: %.2f%n", statistics.max());
        writer.printf("Min: %.2f%n", statistics.min());

        double[] ranks = statistics.rank();
        writer.print("Ranks: ");
        for (double rank : ranks) {
            writer.printf("%.0f ", rank);
        }
        writer.println();

        double searchValue = rand.nextDouble() * 15 + 5; // Tìm giá trị ngẫu nhiên trong [5, 20]
        writer.printf("Search for %.2f: Index %d%n", searchValue, statistics.search(searchValue));
        writer.println("Search for 10.0: Index " + statistics.search(10.0)); // Tìm thêm giá trị cố định

        MyArrayList sorted = list.sortIncreasing();
        writer.println("Original data: " + list);
        writer.println("Sorted data: " + sorted);
    }

    public void testMyLinkedList() {
        /* TODO
           - Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu vào biến length.
           - Tạo một list kiểu MyLinkedList, có các phần tử lưu dữ liệu kiểu double được sinh ngẫu nhiên
             nằm trong đoạn [1, 20]. Tạo Statistics có dữ liệu là list dữ liệu vừa tạo, lưu vào statistics.
           - Sử dụng Statistics để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai, rank, sắp xếp, tìm kiếm).
             In ra terminal tập dữ liệu, tập dữ liệu được sắp xếp, các đại lượng thống kê và kết quả chức năng tìm kiếm.
         */
    }

    public void testMyLinkedList(PrintWriter writer) {
        Random rand = new Random();
        int length = rand.nextInt(21) + 30; // [30, 50]

        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < length; i++) {
            double value = Math.round((rand.nextDouble() * 19 + 1) * 10) / 10.0;
            list.add(value);
        }
        statistics = new Statistics(list);

        writer.println("Statistics Summary:");
        writer.printf("Mean: %.2f%n", statistics.mean());
        writer.printf("Variance: %.2f%n", statistics.variance());
        writer.printf("Max: %.2f%n", statistics.max());
        writer.printf("Min: %.2f%n", statistics.min());

        double[] ranks = statistics.rank();
        writer.print("Ranks: ");
        for (double rank : ranks) {
            writer.printf("%.0f ", rank);
        }
        writer.println();

        double searchValue = rand.nextDouble() * 19 + 1;
        writer.printf("Search for %.2f: Index %d%n", searchValue, statistics.search(searchValue));
        writer.println("Search for 10.0: Index " + statistics.search(10.0));

        MyLinkedList sorted = list.sortIncreasing();
        writer.println("Original data: " + list);
        writer.println("Sorted data: " + sorted);
    }
}