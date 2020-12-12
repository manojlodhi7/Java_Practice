public class SingletonClass2 {

    private static SingletonClass2 singletonClass2 = null;
    private SingletonClass2(){}

    public static SingletonClass2 getSingletonClass2(){
        if(singletonClass2 == null){
            singletonClass2 = new SingletonClass2();
        }
        return singletonClass2;
    }


    public static void main(String[] arg){
        SingletonClass2 sc = SingletonClass2.getSingletonClass2();
        SingletonClass2 sc2 = SingletonClass2.getSingletonClass2();

        System.out.println(sc.getClass() + " : " + sc2.getClass());
        System.out.println(sc == sc2);
    }

}
