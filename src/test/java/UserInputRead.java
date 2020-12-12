//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

public class UserInputRead {

    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input */

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name1 = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name1 + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name2 = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name2 + ".");    // Writing output to STDOUT



    }
}
