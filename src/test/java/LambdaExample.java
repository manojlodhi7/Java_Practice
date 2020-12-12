import java.util.HashMap;
import java.util.Map;

@FunctionalInterface
interface myLambda{
    int sum(int a, int b);
}


public class LambdaExample {
    public static void main(String[] args) throws Exception {
        myLambda s = (a, b) -> a+b;
//        myLambda s = Integer::sum;
        System.out.println(s.sum(20, 30));

    }
}
