public class SingletonClass {

    private static SingletonClass singletonClass = new SingletonClass();
    private SingletonClass(){}

    public static SingletonClass getSingletonClass(){
        return singletonClass;
    }

    public static void main(String[] arg){
        SingletonClass sc = SingletonClass.getSingletonClass();
        SingletonClass sc2 = SingletonClass.getSingletonClass();

        System.out.println(sc.getClass() + " : " + sc2.getClass());
        System.out.println(sc == sc2);
    }
}
