public class InnerClassExample
{
    InnerClassExample()
    {
        System.out.println("out");
    }

    void fun()
    {
        (new Inner() {}).go();
    }

    class Inner
    {
        Inner()
        {
            System.out.print("in");
        }
        public void go()
        {
            System.out.println("go_in");
        }
    }

    public static void main (String [] args)
    {
        InnerClassExample obj = new InnerClassExample();
        obj.fun();

        Inner iObj = obj.new Inner();
        iObj.go();

        InnerClassExample.Inner iiObj = obj.new Inner();
        iiObj.go();
    }

}