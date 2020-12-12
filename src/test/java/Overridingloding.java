class Baap{

    String a = "Parent";
    public static void m1(){
        System.out.println("public static Parent m1");
    }
    public void m2(){
        System.out.println("public parent m2");
    }
    private void m3(){
        System.out.println("private parent m3");
    }
    public void m4(){
        System.out.println("public parent m4 without arguments");
    }
    public void m5(){
        System.out.println("public parent m5 without arguments");
    }
    public void m5(int i){
        System.out.println("public parent m5 wit arguments " + i);
    }

}

public class Overridingloding extends Baap {
    String a = "Child";

    public static void m1(){
        System.out.println("public static Child m1");
    }
    public void m2(){
        System.out.println("public Child m2");
    }
    private void m3(){
        System.out.println("private Child m3");
    }
    public void m4(int i){
        System.out.println("public Child m4 with arguments " + i);
    }
    public void m5(int i){
        System.out.println("public Child m5 with arguments " + i);
    }
    public void m5(int i, int j){
        System.out.println("public Child m5 with arguments " + i + " " + j);
    }

    public static void main(String[] arg){
        System.out.println("***************Baap bp = new Baap();*************************************");
        Baap bp = new Baap();
        System.out.println(bp.a);
        bp.m1(); // static method
        bp.m2();
//        bp.m3(); // private access
        bp.m4();
        bp.m5();
        bp.m5(44);
//        bp.m5(3,5); // cannot access child methods
        System.out.println("***************Baap bporl = new Overridingloding();*************************************");
        Baap bporl = new Overridingloding();
        System.out.println(bporl.a);
        bporl.m1(); // static method
        bporl.m2();
        ((Overridingloding) bporl).m3(); // private access // casting
        bporl.m4();
        bporl.m5();
        bporl.m5(4);
        ((Overridingloding) bporl).m5(2, 5); // casting
        ((Overridingloding) bporl).m4(55); // casting
        System.out.println("***********Overridingloding orl = new Overridingloding();*****************************************");
        Overridingloding orl = new Overridingloding();
        System.out.println(orl.a);
        orl.m1();
        orl.m2();
        orl.m3();
        orl.m4();
        orl.m4(53);
        orl.m5();
        orl.m5(44);
        orl.m5(5,7);
        System.out.println("***********Overridingloding orlbp = (Overridingloding) new Baap();*****************************************");
//        Overridingloding orlbp = (Overridingloding) new Baap(); // ClassCastException
    }
}
