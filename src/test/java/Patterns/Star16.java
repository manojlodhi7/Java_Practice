package Patterns;
/*
9 8 7 6 5 4 3 2 1
  8 7 6 5 4 3 2 1
    7 6 5 4 3 2 1
      6 5 4 3 2 1
        5 4 3 2 1
          4 3 2 1
            3 2 1
              2 1
                1
*/
public class Star16 {
    public static void main(String[] args) {
        int n = 9;
        for(int i = 0; i<= n; i++){ // started with 0
            for(int j = 0; j<i; j++){ // started with 0
                System.out.print("  ");
            }
            for(int j = n-i; j>=1; j--){  // Changed n-i from Star15
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }
}
