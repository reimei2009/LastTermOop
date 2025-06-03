package hus.oop.statistics;

public interface MyIterator {
    /*
     * Kiểm tra xem danh sách có còn phần tử không.
     * @return true nếu còn, false nếu không còn.
     */
    boolean hasNext();

    /*
     * iterator dịch chuyển sang phần tử kế tiếp của dánh sách và trả ra phần tử hiện tại.
     * @return
     */
    Number next();

    /*
     * Xóa phần tử hiện tại của danh sách.
     */
    void remove();
}
