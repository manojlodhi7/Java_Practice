class SingletonExample{

    private static SingletonExample singletonExample = null;
    private SingletonExample(){

    }

    public static SingletonExample getSingletonClass2(){
        if(singletonExample == null){
            singletonExample = new SingletonExample();
        }
        return singletonExample;
    }
}

public class SingletonClass2 {
    public static void main(String[] arg){
        SingletonExample sc = SingletonExample.getSingletonClass2();
        SingletonExample sc2 = SingletonExample.getSingletonClass2();

        System.out.println(sc.getClass() + " : " + sc2.getClass());
        System.out.println(sc == sc2);
    }

}
