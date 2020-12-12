import java.util.*;

public class Third_LargestNum_In_List {


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
        System.out.println("Array List : " + Arrays.toString(intArray));
        System.out.println("Third largest number : " + intArray[2]);
        return intArray[2];

    }

    public static void main(String args[] ) throws Exception {
        int[] n = {23, 34, 6, 98, 23, 65, 6, 73};
        Third_LargestNum_In_List spObj = new Third_LargestNum_In_List();
        spObj.thirdLargestNum(n);
    }
}
