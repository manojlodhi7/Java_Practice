public class mountain_valley_problem {

//    https://www.hackerrank.com/challenges/counting-valleys/problem?isFullScreen=true

    static int countingValleys(String s) {
        int current_level = 0;
        int previous_level = 0;
        int vally = 0;
        for(String step : s.split("")){
            if(step.equalsIgnoreCase("U")){
                current_level++;
            }
            else if(step.equalsIgnoreCase("D")){
                current_level--;
            }
            if((current_level < 0) && (previous_level == 0)){
                System.out.println("in vally");
                vally++;
            }
            previous_level = current_level;
        }

        return vally;
    }

    public static void main(String[] ags){

        System.out.println(countingValleys("DDUUDDUDUUUD"));
    }
}
