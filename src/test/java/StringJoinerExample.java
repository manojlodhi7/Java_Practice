import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class StringJoinerExample {

    public static void joinString(List<String> strList){
        StringJoiner sj = new StringJoiner("|");

        strList.forEach(str -> sj.add(str));
//        strList.forEach(sj::add);
        System.out.println(sj);
    }

    public static void main(String[] arg){
        joinString(Arrays.asList("a","b","c"));
    }
}
