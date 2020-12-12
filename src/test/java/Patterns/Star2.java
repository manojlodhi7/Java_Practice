package Patterns;
/*
        1 2 3 4 5 6 7 8 9 10
        1 2 3 4 5 6 7 8 9 10
        1 2 3 4 5 6 7 8 9 10
        1 2 3 4 5 6 7 8 9 10
        1 2 3 4 5 6 7 8 9 10
        1 2 3 4 5 6 7 8 9 10
        1 2 3 4 5 6 7 8 9 10
        1 2 3 4 5 6 7 8 9 10
        1 2 3 4 5 6 7 8 9 10
        1 2 3 4 5 6 7 8 9 10
*/

public class Star2 {

    public static void main(String args[]){
        for(int i = 1; i<=10; i++){
            for(int j = 1; j<=10; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
