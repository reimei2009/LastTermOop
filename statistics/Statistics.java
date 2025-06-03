package hus.oop.statistics;

public class Statistics {
    private MyList data;

    /**
     * Khởi tạo dữ liệu cho BasicStatistic.
     */
    public Statistics(MyList data) {
        this.data = data;
    }

    /**
     * Lấy giá trị lớn nhất trong list.
     * @return giá trị lớn nhất.
     */
    public double max() {
        double max = Double.NEGATIVE_INFINITY;
        MyIterator it = data.iterator(0);
        while (it.hasNext()) {
            double value = it.next().doubleValue();
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    /**
     * Lấy giá trị nhỏ nhất trong list.
     * @return giá trị nhỏ nhất.
     */
    public double min() {
        double min = Double.POSITIVE_INFINITY;
        MyIterator it = data.iterator(0);
        while (it.hasNext()) {
            double value = it.next().doubleValue();
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    /**
     * Tính kỳ vọng của mẫu theo dữ liệu trong list.
     * @return kỳ vọng.
     */
    public double mean() {
        double sum = 0;
        int count = 0;
        MyIterator it = data.iterator(0);
        while (it.hasNext()) {
            sum += it.next().doubleValue();
            count++;
        }
        return count > 0 ? sum / count : 0;
    }

    /**
     * Tính phương sai của mẫu theo dữ liệu trong list.
     * @return phương sai.
     */
    public double variance() {
        double mean = mean();
        double sumSquaredDiff = 0;
        int count = 0;
        MyIterator it = data.iterator(0);
        while (it.hasNext()) {
            double value = it.next().doubleValue();
            sumSquaredDiff += (value - mean) * (value - mean);
            count++;
        }
        return count > 1 ? sumSquaredDiff / (count - 1) : 0;
    }

    /**
     * Tìm kiếm trong list có phẩn tử nào có giá trị bằng data không, sử dụng binarySearch trong list.
     * Trả về index một phần tử có giá trị bằng data, nếu không tìm thấy thì trả về -1.
     * @return
     */
    public int search(double data) {
        return this.data.binarySearch(data);
    }

    /**
     * Tính rank của các phần tử trong list.
     * @return rank của các phần tử trong list
     */
    public double[] rank() {
        double[] ranks = new double[data.size()];
        MyIterator it = data.iterator(0);
        int index = 0;
        while (it.hasNext()) {
            double value = it.next().doubleValue();
            int rank = 1;
            MyIterator compareIt = data.iterator(0);
            while (compareIt.hasNext()) {
                if (compareIt.next().doubleValue() < value) {
                    rank++;
                }
            }
            ranks[index++] = rank;
        }
        return ranks;
    }
}