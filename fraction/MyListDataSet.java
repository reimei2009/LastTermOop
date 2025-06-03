package hus.oop.fraction;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MyListDataSet implements MyDataSet {
    private List<MyFraction> fractions;

    /**
     * Hàm dựng khởi tạo list chứa các phân số.
     */
    public MyListDataSet() {
        fractions = new ArrayList<>();
    }

    /**
     * Hàm dựng khởi tạo list chứa các phân số theo truyền vào.
     * @param fractions
     */
    public MyListDataSet(List<MyFraction> fractions) {
        this.fractions = new ArrayList<>();
        if (fractions != null) {
            for (MyFraction fraction : fractions) {
                this.fractions.add(new MyFraction(fraction));
            }
        }
    }

    @Override
    public boolean insert(MyFraction fraction, int index) {
        if (index < 0 || index > fractions.size() || fraction == null) return false;
        if (fractions.size() + 1 > Integer.MAX_VALUE) return false;
        List<MyFraction> temp = new ArrayList<>(fractions);
        Collections.copy(temp, fractions);
        fractions.clear();
        fractions.addAll(temp.subList(0, index));
        fractions.add(new MyFraction(fraction));
        fractions.addAll(temp.subList(index, temp.size()));
        return true;
    }

    @Override
    public boolean append(MyFraction fraction) {
        if (fraction == null || fractions.size() >= Integer.MAX_VALUE) return false;
        return insert(fraction, fractions.size());
    }

    @Override
    public MyListDataSet toSimplify() {
        MyListDataSet simplified = new MyListDataSet();
        for (int i = 0; i < fractions.size(); i++) {
            MyFraction newF = new MyFraction(fractions.get(i));
            newF.simplify();
            simplified.fractions.add(newF);
        }
        return simplified;
    }

    public MyListDataSet sortIncreasing() {
        MyListDataSet sorted = new MyListDataSet(fractions);
        Collections.sort(sorted.fractions, (f1, f2) -> {
            int valueCompare = f1.compareTo(f2);
            if (valueCompare == 0) {
                return Integer.compare(f1.getDenominator(), f2.getDenominator());
            }
            return valueCompare;
        });
        return sorted;
    }

    public MyListDataSet sortDecreasing() {
        MyListDataSet sorted = new MyListDataSet(fractions);
        Collections.sort(sorted.fractions, (f1, f2) -> {
            int valueCompare = f2.compareTo(f1);
            if (valueCompare == 0) {
                return Integer.compare(f2.getDenominator(), f1.getDenominator());
            }
            return valueCompare;
        });
        return sorted;
    }

    @Override
    public String myDataSetToString() {
        return "[" + String.join(", ", fractions.stream().map(MyFraction::toString).toArray(String[]::new)) + "]";
    }

    @Override
    public void print() {
        System.out.println(myDataSetToString());
    }
}