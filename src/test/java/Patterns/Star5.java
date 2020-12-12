package Patterns;
/*
        1
        1 2
        1 2 3
        1 2 3 4
        1 2 3 4 5
        1 2 3 4 5 6
        1 2 3 4 5 6 7
        1 2 3 4 5 6 7 8
        1 2 3 4 5 6 7 8 9
        1 2 3 4 5 6 7 8 9 10
*/
public class Star5 {
    public static void main(String args[]){
        for(int i = 1; i<=10; i++){
            for(int j = 1; j<=i; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }
}
