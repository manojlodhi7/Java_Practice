package Patterns;
/*
          1
        1 2 1
      1 2 3 2 1
    1 2 3 4 3 2 1
  1 2 3 4 5 4 3 2 1
*/
public class Star18 {
    public static void main(String[] args) {
        int n = 5;
        for(int i = 0; i<n; i++){
            for(int j = n-i; j>0; j--){
                System.out.print("  ");
            }
            for(int j = 1; j<=i+1; j++){
                System.out.print(j + " ");
            }
            for(int j = i; j>0; j--){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
