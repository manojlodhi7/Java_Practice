public class ExtractDigitFromString {
    public static void main(String[] arg){
        String s = "sdfds!23r21vcxv23";

        String[] sArray = s.split("[^0-9]");
        int total = 0;
        for(String f : sArray){
            if(!f.isEmpty()){
                total = total + Integer.parseInt(f);
            }
        }
        System.out.println(total); // 23+21+23 = 67

        int sum = 0;
        for(int i = 0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
//                sum = sum + Integer.parseInt(Character.valueOf(s.charAt(i)).toString());
                sum = sum + Character.getNumericValue(s.charAt(i));
            }
        }
        System.out.println(sum); // 2+3+2+1+2+3 = 13
    }
}
