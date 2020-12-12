import java.util.ArrayList;
import java.util.Scanner;

interface a{
   default void m1(){
       System.out.println("ERROR!");
   }
}

interface b{
    default void m1(){
        System.out.println("ERROR!");
    }
}

abstract class ok{
    String name;

    ok(String name){
        this.name = name;
        System.out.println(this.name);
    }

    abstract void m2();
}

public class sol2 extends ok implements a, b {

    sol2(String name) {
        super(name);
    }

    @Override
    public void m1() {
        a.super.m1();
    }

    @Override
    public void m2() {

    }

    public void m3(){
        b.super.m1();
    }

    public static void main(String[] args) {
        sol2 obj = new sol2("manoj");
    }

   /* public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lists = scan.nextInt();

        ArrayList<ArrayList<Integer>> l1 = new ArrayList<>();

        for(int i =0; i<lists; i++){
            int list = scan.nextInt();

            ArrayList<Integer> l2 = new ArrayList<>();
            for(int j =0; j<list; j++){
                int value = scan.nextInt();
                l2.add(value);
            }
            l1.add(l2);
//            l2.clear();

            System.out.println(l1);
        }

        int out = scan.nextInt();
        for(int i =0; i<out; i++){
            int findex = scan.nextInt();
            int sindex = scan.nextInt();

            if(findex < l1.size()){
                ArrayList<Integer> a2 = l1.get(findex);
                if(sindex < a2.size()){
                    System.out.println(a2.get(sindex));
                } else System.out.println("ERROR!");
            }else System.out.println("ERROR!");
        }
    }*/



}
