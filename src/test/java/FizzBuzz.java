import java.util.Scanner;

public class FizzBuzz {

    public static void main(String[] arg){

//**************************** Third approach is faster
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i = 0; i<t; i++){
            int n = scan.nextInt();

//  ****************************          First Approach
            long startTime = System.nanoTime();
            for(int j = 1; j<=n; j++){
                if(j%3 == 0 && j%5 == 0){
                    System.out.println("FizzBuzz");
                }
                else if(j%5 == 0){
                    System.out.println("Buzz");
                }
                else if(j%3 == 0){
                    System.out.println("Fizz");
                } else System.out.println(j);
            }

            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            System.out.println("Execution time in nanoseconds  : " + timeElapsed);
//  ****************************          Second Approach
            long startTime2 = System.nanoTime();
            for(int j = 1; j<=n; j++){
                if(j%5 == 0){
                    if(j%3 == 0){
                        System.out.println("FizzBuzz");
                    } else System.out.println("Buzz");
                }
                else if(j%3 == 0){
                    System.out.println("Fizz");
                } else System.out.println(j);
            }

            long endTime2 = System.nanoTime();
            long timeElapsed2 = endTime2 - startTime2;
            System.out.println("Execution time in nanoseconds2  : " + timeElapsed2);

//  ****************************          Third Approach
            long startTime3 = System.nanoTime();
            for(int j = 1; j<=n; j++){
                if(j%15 == 0){
                    System.out.println("FizzBuzz");
                }
                else if(j%5 == 0){
                    System.out.println("Buzz");
                }
                else if(j%3 == 0){
                    System.out.println("Fizz");
                } else System.out.println(j);
            }

            long endTime3 = System.nanoTime();
            long timeElapsed3 = endTime3 - startTime3;
            System.out.println("Execution time in nanoseconds3  : " + timeElapsed3);


            System.out.println("Execution time in nanoseconds   : " + timeElapsed);
            System.out.println("Execution time in nanoseconds2  : " + timeElapsed2);
            System.out.println("Execution time in nanoseconds3  : " + timeElapsed3);
        }


    }
}
