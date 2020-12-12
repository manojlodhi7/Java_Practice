
interface ei1{
    void setBalance(int b);
    int getBalance();
}

class ImplementedClass implements ei1{
    private int balance;

    @Override
    public void setBalance(int b) {
        this.balance = b;
    }

    @Override
    public int getBalance() {
        return this.balance;
    }
}

public class EncapsulationExample {
    public static void main(String[] arg){
        ei1 obj = new ImplementedClass();
        obj.setBalance(1000);
        System.out.println(obj.getBalance());
    }
}


