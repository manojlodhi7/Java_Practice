import java.util.Map;
import java.util.Properties;
import java.util.TreeSet;

public class TreeSet_Example {

    public static void main(String[] ar) {

        TreeSet<Integer> ts = new TreeSet<>();
//        ts.add("bc");
        ts.add(1);
        ts.add(0);
        ts.add(5);
        ts.add(2);

        System.out.println(ts);
        ts.forEach(System.out::println);


    }

}
