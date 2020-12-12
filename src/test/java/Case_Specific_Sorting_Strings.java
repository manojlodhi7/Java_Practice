import java.util.*;

public class Case_Specific_Sorting_Strings {

    public static void main(String[] args) {
        String s = "geeFksASforgeGFekSsS"; // o/p = eeeAefFFggkkoGSrsSsS
        char[] charArray = s.toCharArray();
        ArrayList<Integer> index = new ArrayList<>();
        StringBuilder upper = new StringBuilder();
        StringBuilder lower = new StringBuilder();
        for(int i = 0; i<charArray.length; i++){
//            System.out.println(c);
            char c = charArray[i];
            if(Character.isUpperCase(c)){
                upper.append(c);
                index.add(i);
            } else {
                lower.append(c);
            }
        }
        char[] up = upper.toString().toCharArray();
        char[] lo = lower.toString().toCharArray();
        Arrays.sort(up);
        Arrays.sort(lo);
        upper = new StringBuilder(String.valueOf(up));
        lower = new StringBuilder(String.valueOf(lo));
//        System.out.println(upper);
//        System.out.println(index);
        int count = 0;
        for(int i : index){
            lower.insert(i, upper.charAt(count));
            count++;
        }
        System.out.println(s);
        System.out.println(lower);
    }
}
