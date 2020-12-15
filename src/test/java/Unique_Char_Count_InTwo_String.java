public class Unique_Char_Count_InTwo_String {

    public void lengthy_Method() {

        String s1 = "manoj";
        String s2 = "lnodhi";

        String[] s1A = s1.split("");
        String[] s2A = s2.split("");

        int count = 0;
        for(String s: s1A) {
            boolean b = false;
            for(String j : s2A) {
                if(s.equals(j)) {
                    b = true;
                }
            }
            if(!b) {
                count++;
            }
        }

        for(String s: s2A) {
            boolean b = false;
            for(String j : s1A) {
                if(s.equals(j)) {
                    b = true;
                }
            }
            if(!b) {
                count++;
            }
        }

        System.out.println(count);
    }



    public static void main(String[] args) {
        String s1 = "manoj";
        String s2 = "lnodhi";
//      Expected O/P = 7
        String s3 = s1+s2;
        int count = 0;
        String[] sArrays = s3.split("");
        for(int i = 0; i<sArrays.length; i++){
            for(int j = i+1; j<sArrays.length; j++){
                if(sArrays[i].equals(sArrays[j])){
                    count++;
                    break;
                }
            }
        }

        System.out.println(sArrays.length-count*2);// * 2 because n and o occurred twice

    }
}
