import java.util.Scanner;

public class EnumExample {

    enum Days{Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday}

    enum MyConstants {WakeUp, BreakFast, Sleep, getInstance();
        public static void getInstance() {
            System.out.println("anything");
        }
    }


    public static void daysGreeting(Days day){
        switch (day){
            case Friday:
                System.out.println("Beautiful " + day);
                break;
            default:
                System.out.println("Beautiful Evening " + day);
                break;
        }
    }

    public static void main(String[] args){
        System.out.println(Days.Friday);
        daysGreeting(Days.Friday);
        daysGreeting(Days.Monday);

        System.out.println(MyConstants.BreakFast);
        MyConstants.getInstance();

    }
}
