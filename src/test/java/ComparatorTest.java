import java.util.Comparator;
import java.util.TreeSet;

class MyComparator implements Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
        Integer i1 = (Integer)o1;
        Integer i2 = (Integer)o2;
        return i2.compareTo(i1);
    }
}

class MyStringComparator implements Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
        return o2.toString().compareTo(o1.toString());
    }
}

public class ComparatorTest {
    public static void main(String[] arg){
        TreeSet<Integer> ts = new TreeSet<>(new MyComparator());
        ts.add(12);
        ts.add(33);
        ts.add(11);
        ts.add(7);
        System.out.println(ts);

        TreeSet<String> sts = new TreeSet<>(new MyStringComparator());
        sts.add("abc");
        sts.add("bcd");
        sts.add("cde");
        sts.add("def");
        System.out.println(sts);
    }
}
