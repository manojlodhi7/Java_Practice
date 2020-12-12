import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Delete_MinMaxLength_StringFrom_List implements Comparator<Object> {

    public int compare(Object o1, Object o2) {
        Integer i1 = o1.toString().length();
        Integer i2 = o2.toString().length();
        return i1.compareTo(i2);
    }

    public static List<String> deleteString(List<String> sList) {

        sList.sort(new Delete_MinMaxLength_StringFrom_List());
        return sList.subList(1, sList.size()-1);


        /*String min = sList.get(0);
        String max = sList.get(0);
        for(String s : sList) {
            if(s.length() > max.length()) {
                max = s;
            }
            if(s.length() < min.length()) {
                min = s;
            }
        }

        sList.remove(min);
        sList.remove(max);
        return sList;*/
    }
    public static void main(String[] s) {
        String[] sAry = {"aff", "34563674", "hjkikmrf", "68784", "6gf77877776784"};
        // Output [68784, 34563674, hjkikmrf]

        List<String> alphaNum = new ArrayList<>(Arrays.asList(sAry));
        System.out.println(deleteString(alphaNum));// min and max length string

    }
}
