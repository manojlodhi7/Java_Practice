import java.util.Arrays;
import java.util.List;

public class Arrays_asList {
    public static void main(String[] ar) {
        String[] s = "dfysfjsdio".split("");
        List<String> l = Arrays.asList(s);
        System.out.println(l.toString());
        l.get(0);
        l.set(0, "u");
        System.out.println(l.toString());

        Integer[] i = {9,11,21,3,14,5,16};
        List<Integer> lst = Arrays.asList(i);
        // asList only accept object type (primitives like int, char, long etc not allowed)
        System.out.println(lst);
        Arrays.sort(i);
        System.out.println(lst);



    }
}
