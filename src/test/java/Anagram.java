import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {

    static boolean isAnagram(String a, String b) {
        if(a == null || b == null || a.length() != b.length()){
            return false;
        } else {
            String al = a.toLowerCase();
            String bl = b.toLowerCase();

            String[] ala = a.toLowerCase().split("");
            for(int i = 0; i<al.length(); i++){
                bl = bl.replace(ala[i], "");
                al = al.replace(ala[i], "");
                if(bl.length() != al.length()) {
                    return false;
                }

            }

        }
        return true;
    }
	
	public boolean anagram(String a, String b){
        if(a == null || b == null || a.length() != b.length()){
            return false;
        } else {
            String al = a.toLowerCase();
            String bl = b.toLowerCase();
            Map<Character, Integer> map = new HashMap<>();
            for(int i = 0; i<al.length(); i++) {
                if(map.containsKey(al.charAt(i))) {
                    map.put(al.charAt(i), map.get(al.charAt(i)) + 1);
                } else {
                    map.put(al.charAt(i), 1);
                }
            }

            for (int i = 0; i<bl.length(); i++){
                if(map.containsKey(al.charAt(i))) {
                    map.put(al.charAt(i), map.get(al.charAt(i)) - 1);
                } else {
                    return false;
                }
            }

            for(Integer i: map.values()){
                if( i >= 0){
                    return false;
                }
            }
        }
        return true;
    }
	
	
	
	static void isAnagram2(String str1, String str2) {  
        String s1 = str1.replaceAll("\\s", "");  
        String s2 = str2.replaceAll("\\s", "");  
        boolean status = true;  
        if (s1.length() != s2.length()) {  
            status = false;  
        } else {  
            char[] ArrayS1 = s1.toLowerCase().toCharArray();  
            char[] ArrayS2 = s2.toLowerCase().toCharArray();  
            Arrays.sort(ArrayS1);
            Arrays.sort(ArrayS2);  
            status = Arrays.equals(ArrayS1, ArrayS2);  
        }  
        if (status) {  
            System.out.println(s1 + " and " + s2 + " are anagrams");  
        } else {  
            System.out.println(s1 + " and " + s2 + " are not anagrams");  
        }  
    }



  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
