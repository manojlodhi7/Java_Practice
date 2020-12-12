import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

    public class Climbing_the_Leaderboard {

        // Complete the climbingLeaderboard function below.
        static int[] climbingLeaderboard(int[] scores, int[] alice) {
            int[] al = new int[alice.length];
            HashMap<Integer, Integer> hm = new HashMap<>();
            int rank = 1;
            for(int i : scores){
                if(!hm.containsValue(i)){
                    hm.put(rank, i);
                    rank++;
                }
            }
            System.out.println("hm :" + hm);
            int counter =0;
            for(int i : alice){
                System.out.println("i :" + i);
                for(int j=1; j<=hm.size(); j++){
                    if(i >= hm.get(j)){
                        al[counter] = j;
                        break;
                    }
                    else if (j == hm.size()){
                        al[counter] = j+1;
                        break;
                    }
                }
                counter++;
            }
            return al;

        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int scoresCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] scores = new int[scoresCount];

            String[] scoresItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < scoresCount; i++) {
                int scoresItem = Integer.parseInt(scoresItems[i]);
                scores[i] = scoresItem;
            }

            int aliceCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] alice = new int[aliceCount];

            String[] aliceItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < aliceCount; i++) {
                int aliceItem = Integer.parseInt(aliceItems[i]);
                alice[i] = aliceItem;
            }

            int[] result = climbingLeaderboard(scores, alice);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write("\n");
                }
            }

            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }
