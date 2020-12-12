import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/*Example:
Input
3
aab -> Output =  ab
aebaecedabbee -> Output =  aebcd
ab -> Output =  ab

Output
1
8
0*/

public class Minimum_changes_to_make_all_substrings_distinct {

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        scan.nextLine();
        for(int i = 0; i<T; i++){
            String sinput = scan.nextLine();
            String[] sr = sinput.split("");
            //  System.out.println("sinput : " + sinput);
            HashMap<String, Integer> hm = new HashMap<>();
            for(String s : sr){
                if(hm.containsKey(s)){
                    hm.put(s, hm.get(s) + 1);
                } else hm.put(s, 1);
            }
            int count = 0;
            for(Map.Entry<String, Integer> me : hm.entrySet()){
                int val = me.getValue();
                //  System.out.println("val : " + val);
                if(val > 1){
                    count = count + val - 1;
                }
            }

            System.out.println(count);
        }
    }

}
