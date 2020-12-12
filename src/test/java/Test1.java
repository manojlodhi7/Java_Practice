import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Pattern;

public class Test1 {

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
	
	

    public static void main(String args[] ) throws Exception {
        int[] n = {23, 34, 6, 98, 23, 65, 6, 73};
        String[] sAry = {"afaf", "345634", "hjkikm", "676784", "6gf76784"};

        List<String> alphaNum = new ArrayList<>(Arrays.asList(sAry));

        Test1 tObj = new Test1();
        tObj.isNumber(alphaNum);
        tObj.thirdLargestNum(n);

    }
}
