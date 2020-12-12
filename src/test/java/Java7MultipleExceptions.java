public class Java7MultipleExceptions {

    public static void main(String[] args) {
        try{
            rethrow("abc");
        }catch(FirstException | SecondException | ThirdException e){
            //below assignment will throw compile time exception since e is final
            //e = new Exception();
            System.out.println(e.getMessage());
        }
    }

    static void rethrow(String s) throws FirstException, SecondException,
            ThirdException {
        try {
            if (s.equals("First"))
                throw new FirstException();
            else if (s.equals("Second"))
                throw new SecondException();
            else
                throw new ThirdException("With Custom message");
        } catch (Exception e) {
            //below assignment disables the improved rethrow exception type checking feature of Java 7
            // e=new ThirdException();
            throw e;
        }
    }

    static class FirstException extends Exception {

        public FirstException() {
            super("First Custom Exception msg");
        }
    }

    static class SecondException extends Exception {

        public SecondException() {
            super("Second Custom Exception msg");
        }
    }

    static class ThirdException extends Exception {

        public ThirdException(String msg) {
            super("Third Custom Exception msg : " + msg);
        }
    }

}