import java.util.HashMap;
import java.util.Map;
import java.util.Map.*;
import java.util.Set;
import java.util.Set.*;
import java.util.stream.Stream;

public class DupChar {

    public static void main(String[] arg) {

        String input = "A B ABCABC AB A B ggjklrf";
        String withoutSpaces = input.replace(" ", "");

        System.out.println("Count of spaces" + (input.length() - withoutSpaces.length()));

        HashMap<String, Integer> dupS = new HashMap<>();

        String[] withoutSArray = withoutSpaces.split("");

        for(String s: withoutSArray) {

            if(dupS.containsKey(s)) {
                dupS.put(s, dupS.get(s) + 1);
            }
            else {
                dupS.put(s, 1);
            }
        }


//        Set<String> character = dupS.keySet();
//        for(String st : character) {
//            System.out.println(st + " => " + dupS.get(st));
//        }


//        Set entry = dupS.entrySet();

//        for(Map.Entry<String, Integer> em : entry) {
//            System.out.println(em.getKey() + " => " + em.getValue());
//        }



//        dupS.forEach((key, value) -> System.out.println(key + " : " + value));

//        Stream<Entry<String, Integer>> stream = dupS.entrySet().stream();
//        stream.filter(v -> v.getValue()>1).forEach( v -> System.out.println(v.getKey() + " : " + v.getValue()));

        dupS.entrySet().stream().filter(v -> v.getValue()>1).forEach( v -> System.out.println(v.getKey() + " : " + v.getValue()));

    }

}