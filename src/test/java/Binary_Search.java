import java.io.IOException;
import java.util.Arrays;

public class Binary_Search {

    public static void main(String[] ar) throws IOException {
        int[] a = {9, 5, 8, 33, 11, 7, 17, 1};
        Arrays.sort(a); // Mandatory to sort before binary search operation
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.binarySearch(a, 33));
        System.out.println(Arrays.binarySearch(a, 1));
        System.out.println(Arrays.binarySearch(a, 50));

        System.out.println("\n");

        String[] s = "dfysfjsdio".split("");
        Arrays.sort(s);
        System.out.println(Arrays.toString(s));
        System.out.println(Arrays.binarySearch(s, "o"));
        System.out.println(Arrays.binarySearch(s, "s"));
        System.out.println(Arrays.binarySearch(s, "y"));
        System.out.println(Arrays.binarySearch(s, "S"));
        System.out.println(Arrays.binarySearch(s, "5"));

    }
}
