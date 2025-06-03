package hus.oop.statistics;

public interface MyList extends MyIterable {
    /**
     * Lấy kích thước của list.
     * @return
     */
    int size();

    /**
     * Thêm phần tử có dữ liệu data váo cuối list.
     * @param data
     */
    void add(double data);

    /**
     * Thêm phần tử có dữ liệu data vào list ở vị trí index.
     * @param data
     * @param index
     */
    void insert(double data, int index);

    /**
     * Xóa phần tử ở vị trí index.
     * @param index
     */
    void remove(int index);

    /**
     * Sắp xếp các phần tử trong list theo thứ tự tăng dần.
     * Trả ra list mới với các phần tử được sắp xếp, không làm thay đổi dữ liệu gốc.
     * @return list được sắp xếp theo thứ tự tăng dần
     */
    MyList sortIncreasing();

    /**
     * Tìm kiếm trong list có phẩn tử nào có giá trị bằng data không, sử dụng thuật toán tìm kiếm nhị phân.
     * Trả về index một phần tử có giá trị bằng data, nếu không tìm thấy thì trả về -1.
     * @param data
     * @return index của một phần tử có giá trị bằng data, nếu không có trả về -1
     */
    int binarySearch(double data);
}
