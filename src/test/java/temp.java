import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

// in = string, frst char in string

public class temp{


    public void firstUnique(String str){
        String[] strArry = str.split("");
        int count = 0;
        boolean flag = true;
        String lastUn;
        for(int i = 0; i<strArry.length; i++) {
//            System.out.println("strArry[i] : " + strArry[i]);
            String subStr = str.substring(i+1, str.length());
            String subStr2 = str.substring(0, i);
            if(!(subStr.contains(strArry[i])) && !(subStr2.contains(strArry[i]))) {
                count++;
                lastUn = strArry[i];
                if(count == 6) {
                    System.out.println(strArry[i]);
                    flag = false;
                    break;
                }

            }
        }



        /* // Simple solution with stream, filter, forEach, lambda and method reference
        LinkedHashMap<Character, Integer> lhmap = new LinkedHashMap<>();
        for(int i=0; i<str.length(); i++){
            if(lhmap.containsKey(str.charAt(i))){
                lhmap.put(str.charAt(i), lhmap.get(str.charAt(i)) + 1);
            } else lhmap.put(str.charAt(i), 1);
        }
        lhmap.entrySet().stream().filter(kv -> kv.getValue() ==1).limit(1).forEach(System.out::println);*/



    }


    public void setPropValues(String attribute, String value) throws IOException {
        Properties prop = new Properties();
//        String propFileName = System.getProperty("user.dir").replace("\\", "/") + "/src/test/config.properties";
//        System.out.println(System.getProperty("user.dir"));


        File file = new File(
                getClass().getClassLoader().getResource("config.properties").getFile().replace("%20", " ")
        );

        try {
            prop.load(new BufferedReader(new FileReader(file)));
            prop.setProperty(attribute, value);
            prop.store(new BufferedWriter(new FileWriter(file)), "");
        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    public static String getSmallestAndLargest(String s, int n) {
        // "abczyxyzx", 3
        // Dictionary sorting - Output will be first and last string of length n

        /*String smallest = "";
        String largest = "";
        smallest = s.substring(0, n);
        largest = s.substring(0, n);
        for(int i = 1; i<s.length()-n+1; i++){
            String k = s.substring(i, i+n);
            if(k.compareToIgnoreCase(smallest)<0){
//                System.out.println((k.compareTo(smallest))  + "  smallest " + k);
                smallest = k;
            }
            System.out.println((largest.compareToIgnoreCase(k))  + "  k " + k + " largest " + largest);
            if(k.compareToIgnoreCase(largest)>0){
                largest = k;
            }
        }

        System.out.println(smallest + "  " + largest);
        return smallest + "\n" + largest;*/


        // ***************************************************** Much simpler version
        TreeMap<String, Integer> tmap = new TreeMap<>();
        StringBuffer sb;
        for(int i = 0; i<s.length()-n; i++){
            sb = new StringBuffer(s.substring(i, i+n));
            tmap.put(sb.toString(), 1);
        }
        System.out.println(tmap.firstKey() + "\n" + tmap.lastKey());
        return tmap.firstKey() + "\n" + tmap.lastKey();
    }


    public static boolean anagram(String a, String b){
        // An anagram of a string is another string that contains same characters, only the order of characters can be different. For example, “abcd” and “dabc” are anagram of each other.

        /*if(a == null || b == null || a.length() != b.length()){
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
        return true;*/



        // Simpler way
        if(a == null || b == null || a.length() != b.length()){
            return false;
        } else {
            char[] ac = a.toCharArray();
            char[] bc = b.toCharArray();
            Arrays.sort(ac);
            Arrays.sort(bc);
            return Arrays.equals(ac, bc);
        }

    }

    public static void main(String[] s2) throws IOException {
        temp obj = new temp();
//        obj.setPropValues("arn_MODEL_PERFORMANCE_REPORT", "Manoj");
//        obj.setPropValues("arn_MODEL_ABC", "Lodhi");
//        System.out.println(System.getProperty("user.dir"));
//        System.out.println(temp.class.getClassLoader().getResource("config.properties"));
//        System.out.println(temp.class.getClassLoader());

//        getSmallestAndLargest("abczyxyzx", 3);
        System.out.println(anagram("abcee", "deabc"));



    }
}
