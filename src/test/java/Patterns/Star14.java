package Patterns;
/*
9 8 7 6 5 4 3 2 1
 9 8 7 6 5 4 3 2
  9 8 7 6 5 4 3
   9 8 7 6 5 4
    9 8 7 6 5
     9 8 7 6
      9 8 7
       9 8
        9
*/
public class Star14 {
    public static void main(String[] args) {
        int n = 9;
        for(int i = 1; i<= n; i++){
            for(int j = 1; j<i; j++){
                System.out.print(" ");
            }
            for(int j = n; j>=i; j--){
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }
}
