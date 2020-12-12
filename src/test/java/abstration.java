import java.util.*;
abstract class Book{
    String title;
    Book(){
        System.out.println("Abstract class constructor");
    }
    abstract void setTitle(String s);
    String getTitle(){
        return title;
    }

}

class MyBook extends Book{

    public void setTitle(String s){
        this.title = s;
    }

}

public class abstration{

    public static void main(String []args){
        //Book new_novel=new Book(); This line prHMain.java:25: error: Book is abstract; cannot be instantiated
        String s1="Manoj";
        String s2="manoj";

        System.out.println(s1.compareTo(s2));
        System.out.println(s1.compareToIgnoreCase(s2));
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));


//        MyBook new_novel=new MyBook();
//        new_novel.setTitle(title);
//        System.out.println("The title is: "+new_novel.getTitle());

//        try{
//            int a = 10/0;
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            System.out.println(e.getClass().getName()+ ": " + e.getMessage());
//        }

    }
}