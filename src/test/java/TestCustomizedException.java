public class TestCustomizedException {
    int i;

    void setI(int i) {
        if(i>50) {
//            throw new CustomException("Value is too large");
            throw new ArithmeticException("large value");
        }
        this.i = i;
    }

    public static void main(String[] s) {
        TestCustomizedException obj = new TestCustomizedException();
        obj.setI(55);
    }
}
