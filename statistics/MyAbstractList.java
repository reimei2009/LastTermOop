package hus.oop.statistics;

public abstract class MyAbstractList implements MyList {
    /**
     * Mô tả dữ liệu của list.
     * @return mô tả list theo định dạng [a1 a2 a3 ... an]
     */
    @Override
    public String toString() {
        String result = "[";
        MyIterator it = iterator(0);
        while (it.hasNext()) {
            result += it.next();
            if (it.hasNext()) {
                result += " ";
            }
        }
        return result + "]";
    }
}