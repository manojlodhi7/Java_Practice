public class ContainsEveryLetterOfEnglishAlphabet {

//    A program is a sentence containing every letter in the English Alphabet.

    public static boolean ContainsAllEnglishAlphabets(String str)
    {
        String[] alphas = "qwertyuioplkjhgfdsazxcvbnm".split("");
        for(String s : alphas){
            if(!str.toLowerCase().contains(s)){
                return false;
            }
        }
        return true;
    }
    public static boolean checkProgramContainsOnlyAlphabets(String s)
    {
        String str = s.toLowerCase();
        for(int i = 0; i<str.length(); i++){
            int j = (byte)str.charAt(i);
//            System.out.println(j);
            if(j<96 || j >122){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] arg){
        System.out.println(checkProgramContainsOnlyAlphabets("aAzZ"));
        System.out.println(ContainsAllEnglishAlphabets("aAzZ"));
    }
}
