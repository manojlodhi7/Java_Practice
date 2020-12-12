class myCustomrException extends RuntimeException{
    public myCustomrException(String message) {
        super(message);
    }
}

class MyCustException  extends Exception {
    MyCustException(){
        super("Custom exception received");
    }
}

public class CustomException  {

    public static void createCustException(String message) {
        throw new myCustomrException(message);
    }

    public static void main(String[] arg) throws MyCustException {
        CustomException.createCustException("My custom exception");
        throw new MyCustException();
    }

}
