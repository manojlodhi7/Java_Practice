import java.util.Scanner;

public class Decode_the_Pattern {

/*          1
            11
            21
            2111
            111221
            312211
            ............*/

    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
//        int n = 1;
        if(n>2){
            String previousNum = "11";
            for(int i = 2; i<n; i++){
                int nextIndex = 0;
                int prevIndex = 0;
                String nextStr = "";
                String nextNum = "";
                for(int j=1; j<previousNum.length(); j++){
                    String a = String.valueOf(previousNum.charAt(j-1));
                    String b = String.valueOf(previousNum.charAt(j));
                    nextIndex = j;
                    if(!a.equals(b)){
                        nextStr = previousNum.substring(prevIndex, nextIndex);
                        prevIndex = nextIndex;
                        nextNum = nextNum + nextStr.length() + nextStr.charAt(0);
                    }
                }
                nextStr = previousNum.substring(prevIndex, nextIndex+1);
                previousNum = nextNum + nextStr.length() + nextStr.charAt(0);
                System.out.println(previousNum);
                if(i == n-1){
                    System.out.println("Final Value : " + previousNum);
                }
            }
        }
        else if(n==2){
            System.out.println("11");
        } else {
            System.out.println("1");
        }

    }
}
