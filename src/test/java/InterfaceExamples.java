
interface i1{
    static void m1(){
        System.out.println("i1 Static Method");
    }
    default void m2(){
        System.out.println("i1 Defaoult method");
    }
    void m3();
    void m4();
}
interface i2{
    static void m1(){
        System.out.println("i2 Static Method");
    }
    default void m2(){
        System.out.println(" i2 Defaoult method");
    }
    void m4();
    void m5();
}


public class InterfaceExamples implements i1, i2{

    @Override
    public void m2() {
        i1.super.m2();
    }

    @Override
    public void m3() {
        System.out.println("");
    }

    @Override
    public void m4() {

    }

    @Override
    public void m5() {

    }

    public void m6() {

    }


    public static void main(String[] arg){
//        InterfaceExamples obj = new InterfaceExamples();
//        i1 obj = new InterfaceExamples();
        i2 obj = new InterfaceExamples();
        i1.m1();
        i2.m1();
        obj.m2();
    }
}
