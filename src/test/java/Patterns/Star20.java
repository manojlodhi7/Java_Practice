package Patterns;
/*
       *
      * *
     * * *
    * * * *
   * * * * *
    * * * *
     * * *
      * *
       *
 */
public class Star20 {
    public static void main(String[] args) {
        int n = 5;

        for(int i = 0; i<n; i++){
            for(int j = n-i; j>0; j--){
                System.out.print(" ");
            }
            for(int j = 0; j<=i; j++){
                System.out.print("* ");// after space
            }
            System.out.println();
        }

        for(int i = 1; i<n; i++){
            for(int j = 1; j<=i; j++){
                System.out.print(" ");
            }
            for(int j = n-i; j>0; j--){
                System.out.print(" *");// before space
            }
            System.out.println();
        }
    }
}
