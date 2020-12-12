public class FibonacciNumber {

    public static void series(){
        int n = 10;
        int n1 = 0;
        int n2 = 1;
        System.out.print(0 + ",");
        System.out.print(1);
        while(n>2){
            int temp = n1 + n2;
            System.out.print("," + temp);
            n1 = n2;
            n2 = temp;
            n--;
        }
    }

    public static void main(String[] arg){
        // 0, 1,1,2,3,5,8
        int n = 3;
        int n1 = 0;
        int n2 = 1;
        int temp = 0;
        if(n>2){
            System.out.println(n1);
            System.out.println(n2);
            int count = 0;
            while(count < n-2){
                temp = n1 + n2;
                System.out.println(temp);
                n1 = n2;
                n2 = temp;
                count++;
            }
        }
        else if(n == 1) System.out.println(0);
        else if(n==2) System.out.println(0 + "\n" + 1);
    }

}
