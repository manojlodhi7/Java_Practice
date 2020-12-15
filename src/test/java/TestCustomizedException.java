class MyException extends RuntimeException{
    MyException(String msg){
        super(msg);
    }
}

public class TestCustomizedException {
    int i;

    void setI(int i) {
        if(i>50) {
            throw new ArithmeticException("large value");
        }
        else if (i <10){
            throw new MyException("My Custom Exception");
        }
        this.i = i;
    }

    public static void main(String[] s) {
        TestCustomizedException obj = new TestCustomizedException();
        obj.setI(4);
    }
}
