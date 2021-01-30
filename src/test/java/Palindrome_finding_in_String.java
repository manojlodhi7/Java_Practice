import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Palindrome_finding_in_String {

    public static String findPalindrome_withStringBuffer(String str){
//        o/p = racecar
        for(int i =0; i<str.length(); i++){
            String s = str.substring(i);
            StringBuffer sb = new StringBuffer(s);
            sb.reverse();
            if(s.equals(new String(sb))){
                return s;
            }
        }
        return "Not Found";
    }

    public static void findPalindrome_withStringBuffer_ReverseIncluded(String str){
//        o/p = racecar, aceca, cec
        for(int i = 0; i<str.length(); i++){
            for(int j = str.length(); j>i+1; j--){
                String s2 = str.substring(i, j);
                StringBuilder sb = new StringBuilder(s2);
                sb.reverse();
                if(sb.toString().equalsIgnoreCase(s2)){
                    System.out.println(sb);
                }
            }

        }
    }

    public static String findPalindrome_withoutStringBuffer(String str){

        for(int i =0; i<str.length(); i++){
            String s = str.substring(i);
            List<Character> newStr = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
            Collections.reverse(newStr);
            StringJoiner sj = new StringJoiner("");
            newStr.forEach(s2 -> sj.add(s2.toString()));
            if(s.equals(sj.toString())){
                return s;
            }
        }
        return "Not Found";

    }

    public static void main(String[] args) {
        String str = "theracecar";

        System.out.println(findPalindrome_withoutStringBuffer(str));

    }
}
