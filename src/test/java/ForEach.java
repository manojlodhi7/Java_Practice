import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ForEach {
    public static void main(String[] args) {
        /*Map<Object, Object> map = new HashMap<>();
        map.put("manoj", 24);
        map.put("kumar", 30);
        map.forEach((k,v) -> System.out.println("key : " + k + "   Value: " + v));*/



        /*List<Integer> l = new ArrayList<>();
        l.add(45);
        l.add(40);
        l.add(10);
        l.add(50);
        l.add(65);
        l.add(30);
        l.forEach(v -> System.out.println("List Values : " + v));*/

        // List count which > 40
        /*long c = l.stream().filter(cnt -> cnt>40).count();
        System.out.println("List count > 40 : " + c);*/


        // Print 6 digit which are divisible by 3
        Stream.iterate(1, count -> count + 1).filter(v -> v%3 == 0).limit(6).forEach(System.out::println);
    }

}
