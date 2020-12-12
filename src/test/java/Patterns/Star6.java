package Patterns;

/*
A
A B
A B C
A B C D
A B C D E
A B C D E F
A B C D E F G
A B C D E F G H
A B C D E F G H I
A B C D E F G H I J
*/

public class Star6 {
    public static void main(String args[]){
        for(int i = 1; i<=10; i++){
            for(int j = 1; j<=i; j++){
                System.out.print((char)(64 + j) + " ");
            }
            System.out.println();
        }

    }
}
