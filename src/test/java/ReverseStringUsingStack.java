import java.util.Stack;

public class ReverseStringUsingStack {

    public static void main(String[] args) {
        String s = "Manoj";
        Stack<String> rev = new Stack<>();
        for(String c: s.split("")){
            rev.push(c);
        }

        for(int i = 0; i<s.length(); i++){
            System.out.print(rev.pop());
        }
    }
}
