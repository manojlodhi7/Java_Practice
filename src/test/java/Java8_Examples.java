import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class Java8_Examples {

    public static void main(String[] args){
        Integer[] s = {12, 4, 66, 34, 11, 6, 9, 15};
        List<Integer> l = Arrays.asList(s);

        StringJoiner sj = new StringJoiner(",");
        l.forEach(i -> sj.add(i.toString()));
        System.out.println(sj.toString());

        StringJoiner sj2 = new StringJoiner(",");
//        l.stream().filter(i -> i>10).map(i -> i.toString()).forEach(i -> sj2.add(i));
        l.stream().filter(i -> i>10).map(Object::toString).forEach(sj2::add);

        System.out.println(sj2.toString());

    }
}
