import java.util.*;

public class Duplicate_Remove_String {

    public static void removeDupCharWithoutCollection(String str){
        String[] sArray = str.split("");
        StringBuilder sb = new StringBuilder();
        for(String s: sArray){
            if(!sb.toString().contains(s)){
                sb.append(s);
            }
        }
        System.out.println(sb);
    }

    public static void removeDupCharWithCollection(String str){
        Set<String> set = new HashSet<>(Arrays.asList(str.split("")));
        System.out.println(set);
    }


    public static void main(String[] args) {

        removeDupCharWithoutCollection("amamnjonjo");
        removeDupCharWithCollection("amamnjonjo");

    }

}
