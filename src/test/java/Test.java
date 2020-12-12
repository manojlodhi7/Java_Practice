public class Test
{
    Test()
    {
        System.out.print("out");
    }

    class Inner
    {
        Inner()
        {
            System.out.print("in");
        }
        public void go()
        {
            System.out.print("go_in");
        }
    }

    public static void main (String [] args)
    {
        Test obj = new Test();
        obj.fun();
    }
    void fun()
    {
        (new Inner() {}).go();
    }
}