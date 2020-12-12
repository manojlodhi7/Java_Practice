public class StaticBlock_Without_Main_Method {

    // ***********  main method mandatory from java 1.7

    static int i = 9; // 1
    static {
        System.out.println(i);  // 2
    }

    public static void main(String[] args) {
        System.out.println(11);  // 4
    }

    static {
        System.out.println(44);  // 3
    }
}
