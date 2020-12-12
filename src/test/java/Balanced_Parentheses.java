import java.util.*;
class Balanced_Parentheses {

    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String brackets = sc.next();
            Stack<Character> stack = new Stack<Character>();
            boolean result = true;
            char current, previous;
            for(int i = 0; i < brackets.length(); i++) {
                current = brackets.charAt(i);
                if(current == '(' || current == '[' || current == '{') {
                    stack.push(current);
                } else if(current == ')' || current == ']' || current == '}') {
                    if(stack.isEmpty()) {
                        result = false;
                    } else {
                        previous = stack.peek();
                        if((current == ')' && previous == '(') || (current == ']' && previous == '[') || (current == '}' && previous == '{')) {
                            stack.pop();
                        } else {
                            result = false;
                        }
                    }
                }
            }
            if(!stack.isEmpty()) {
                result = false;
            }

            if(stack.empty() || result){
                System.out.println("true");
            } else System.out.println("false");


        }

    }
}



