import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearchExamples {
    public static void main(String[] arg){

        int[] k = {8,2,1,6,7,3,9,5,4};
        Integer[] ik = new Integer[9];
        for(int j : k){
            System.out.print(j);
            ik[j-1] = j;
        }
        System.out.println();
        Arrays.sort(k);
        for(int j : k){
            System.out.print(j);
        }
        System.out.println();
        System.out.println(Arrays.binarySearch(k, 6));
        System.out.println(Arrays.binarySearch(k, 16));
        for(int f : ik){
            System.out.println(f);
        }



        Integer[] al = {8,2,1,6,7,3,9,5,4};
        List<Integer> li = Arrays.asList(al);
        System.out.println(li);
        Collections.sort(li);
        li.set(7, 0);
        for(int j : al){
            System.out.print(" " +j);
        }
        System.out.println();
        System.out.println(Collections.binarySearch(li, 9));
    }
}
