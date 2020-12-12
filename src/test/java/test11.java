import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Pattern;

public class test11 {

    /*public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        for(int i = 0; i < num; i++) {
            s = new Scanner(System.in);
            String name = s.nextLine();
            System.out.println(name.equalsIgnoreCase());
        }

    }*/

    /*public static void main(String[] args) {

        String word = "zzzooooooo";
        int count_z = 0;
        int count_o = 0;
        String[] wArray = word.split("");
        for(String s : wArray) {
            if(s.equalsIgnoreCase("z")) {
                count_z++;
            }
            else if(s.equalsIgnoreCase("o")) {
                count_o++;
            }
        }

        if(2*count_z == count_o) {
            System.out.println("Yes");
        }

    }*/



    /*public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        String[] nArray = name.split(" ");
        int n1 = Integer.parseInt(nArray[0]);
        int n2 = Integer.parseInt(nArray[1]);
        int n3 = Integer.parseInt(nArray[2]);
        int count = 0;
        for(int i = n1; i <= n2; i++) {
            if(i%n3 == 0) {
                count++;
            }
        }
        System.out.println(count);

    }*/


    /*public static void main(String args[] ) throws Exception {
        String name = "aba";
        String[] nArray = name.split("");
        String out = "";
        for(String n: nArray) {
            out = n + out;
        }
        System.out.println(out);
        if(name.equals(out)) {
            System.out.println("YES");
        } else System.out.println("NO");
    }*/

/*
    public static void main(String args[] ) throws Exception {
        String s1 = "manoj";
        String s2 = "lnodhi";

        String[] s1A = s1.split("");
        String[] s2A = s2.split("");

        int count = 0;
        for(String s: s1A) {
            boolean b = false;
            for(String j : s2A) {
                if(s.equals(j)) {
                    b = true;
                }
            }
            if(!b) {
                count++;
            }
        }

        for(String s: s2A) {
            boolean b = false;
            for(String j : s1A) {
                if(s.equals(j)) {
                    b = true;
                }
            }
            if(!b) {
                count++;
            }
        }

        System.out.println(count);
    }

}*/

    public void isNumber(List<String> sList) {
        int count = 0;
        for(String s: sList) {
            boolean isNum = true;

            if(Pattern.matches("[0-9]+", s)) {
                count++ ;
            }

//            OR

/*            for(int i = 0; i<s.length(); i++) {
                if(Character.isAlphabetic(s.charAt(i))) {
                    isNum = false;
                }
            }
            if(isNum) {
                count++;
                System.out.println(s);
            }*/

        }
        System.out.println("Total numeric string : " + count);
        System.out.println("Total non numeric string : " + (sList.size()-count));
    }


    public int thirdLargestNum(int[] intArray) {
        /*ArrayList<Integer> array_list = new ArrayList<Integer>();
        for(int i = 0; i<intArray.length; i++) {
            array_list.add(intArray[i]);
        }
        Collections.sort(array_list);
        Collections.reverse(array_list);
        System.out.println("Total numeric string : " + array_list);
        System.out.println("Third largest number : " + array_list.get(2));
        return array_list.get(2);*/

//        OR

        /*Arrays.sort(intArray);
        System.out.println("Third largest number : " + Arrays.toString(intArray));
        System.out.println("Third largest number : " + intArray[intArray.length-3]);
        return intArray[intArray.length-3];*/

//        OR

        int temp;
        int len = intArray.length;
        for(int i = 0; i<len; i++) {
            for(int j = i+1; j<len; j++) {
                if(intArray[i] < intArray[j]) {
                    temp = intArray[j];
                    intArray[j] = intArray[i];
                    intArray[i] = temp;
                }
            }
        }
        System.out.println("Third largest number : " + Arrays.toString(intArray));
        System.out.println("Third largest number : " + intArray[2]);
        return intArray[2];

    }


    public List<String> deleteString(List<String> sList) {
        String min = sList.get(0);
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
        return sList;
    }

    public void dupChars(String s ) {

        String[] sArray = s.split("");
        HashMap<String, Integer> dup = new HashMap<>();

        for(String sa: sArray){
            if(dup.containsKey(sa)){
                dup.put(sa, dup.get(sa) + 1);
            }
            else {
                dup.put(sa, 1);
            }
        }

        for(Map.Entry me: dup.entrySet()) {
            System.out.println(me.getKey() + " : " + me.getValue());
        }
    }


    public static void main(String args[] ) throws Exception {
        int[] n = {23, 34, 6, 98, 23, 65, 6, 73};
        String[] sAry = {"afaf", "345634", "hjkikm", "676784", "6gf76784"};


        List<String> alphaNum = new ArrayList<>(Arrays.asList(sAry));

//        test tObj = new test();
//        tObj.isNumber(alphaNum);
//        tObj.thirdLargestNum(n);

        HashSet hs = new HashSet();
        hs.add("sds");
        hs.add(23);
        System.out.println(hs);

        Set s = new HashSet();
    }
}
