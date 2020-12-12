
import java.util.Stack;

class StackProblem2 {

    public static void main(String []argh)
    {

        String str="{[{[[[]]((){}[])]}}]";
        Stack<Character> stack = new Stack<>();

        char c;
        char previous;
        for(int i=0; i < str.length(); i++) {
            c = str.charAt(i);

            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }

            else{
                if(stack.empty()){
                    System.out.println("false");
                    break;
                }

                else {
                    previous = stack.peek();
                    if((previous == '(' && c == ')') || (previous == '{' && c == '}') || (previous == '[' && c == ']')){
                        stack.pop();
                    }
                    else {
                        System.out.println("false");
                        break;
                    }
                }
            }
        }


        if(stack.empty()){
            System.out.println("true");
        } else System.out.println("false");




    }
}



