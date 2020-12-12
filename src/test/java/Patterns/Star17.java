package Patterns;
/*
                  0
                1 0 1
              2 1 0 1 2
            3 2 1 0 1 2 3
          4 3 2 1 0 1 2 3 4
        5 4 3 2 1 0 1 2 3 4 5
      6 5 4 3 2 1 0 1 2 3 4 5 6
    7 6 5 4 3 2 1 0 1 2 3 4 5 6 7
  8 7 6 5 4 3 2 1 0 1 2 3 4 5 6 7 8
*/
public class Star17 {
    public static void main(String[] args){
        int n = 9;
        for(int i = 0; i<n; i++){
            for(int j = n-i; j>0; j--){
                System.out.print("  "); // two spaces
            }
            for(int j = i; j>=0; j--){
                System.out.print(j + " ");
            }
            for(int j = 1; j<=i; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
