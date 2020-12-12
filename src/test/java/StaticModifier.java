
public class StaticModifier {

    static int x = 10;
    int y = 20;

    public static void main(String[] ar) {

        StaticModifier obj1 = new StaticModifier();
        obj1.x = 100;
        obj1.y = 200;

        StaticModifier obj2 = new StaticModifier();
        System.out.println(obj2.x + " " + obj2.y);
    }
}
