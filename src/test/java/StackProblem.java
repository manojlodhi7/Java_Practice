import java.util.Stack;

public class StackProblem {

    public boolean isBalanced(String str){
        String[] strArray = str.split("");
        String openingBraces = "{[(";
        Stack<String> stack = new Stack<>();
        for(String s: strArray){
            if(openingBraces.contains(s)){
                stack.push(s);
            }
            else{
                System.out.println("s : " + s);
                if(stack.empty()){
                    System.out.println("stack.empty()");
                    return false;
                }
                String topValue = stack.peek();

                switch (s) {
                    case ")":
                        if (topValue.equals("(")) {
                            stack.pop();
                        } else return false;
                        break;
                    case "}":
                        if (topValue.equals("{")) {
                            stack.pop();
                        } else return false;
                        break;
                    case "]":
                        if (topValue.equals("[")) {
                            stack.pop();
                        } else return false;
                        break;
                }
            }
        }

        return stack.empty();
    }

    public static void main(String[] arg){
        String str = "{[()[{{[]}()}]{}]}()";
        StackProblem obj = new StackProblem();
        System.out.println(obj.isBalanced(str));
    }

}
