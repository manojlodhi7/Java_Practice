public class Static_Instance_Block {
    static {
        System.out.println("Static block");
        m1();
    }

    {
        System.out.println("Instance block");
        m2();
    }

    Static_Instance_Block(){
        System.out.println("Constructor");
    }

    static void m1(){
        System.out.println("Static method m1");
    }

    void m2(){
        System.out.println("Instance method m2");
    }

    void m3(){
        System.out.println("Instance method m3");
    }

    public static void main(String[] args){
        Static_Instance_Block sb = new Static_Instance_Block();
        System.out.println("Static main method");
        sb.m3();
    }
}
