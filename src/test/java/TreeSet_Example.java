import java.util.Map;
import java.util.Properties;
import java.util.TreeSet;

public class TreeSet_Example {

    public static void main(String[] ar) {

        TreeSet<Integer> ts = new TreeSet<>();
//        ts.add("bc");
        ts.add(1);
        ts.add(0);

        ts.forEach(System.out::println);


    }

}
