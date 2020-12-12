import java.util.*;


public class Extract_Numberic_String_FromList {

	public void isNumber(List<String> sList) {
        int count = 0;
        for(String s: sList) {
            boolean isNum = true;

            /*if(Pattern.matches("[0-9]+", s)) {
                count++ ;
            }*/


            for(int i = 0; i<s.length(); i++) {
                if(Character.isAlphabetic(s.charAt(i))) {
                    isNum = false;
                }
            }
            if(isNum) {
                count++;
                //System.out.println(s);
            }

        }
        System.out.println("Total numeric string : " + count);
        System.out.println("Total non numeric string : " + (sList.size()-count));
    }
    
	public static void main(String[] s) {
		String[] sAry = {"aff", "34563674", "hjkikmrf", "68784", "6gf77877776784"};
		List<String> alphaNum = new ArrayList<>(Arrays.asList(sAry));
		Extract_Numberic_String_FromList pObj = new Extract_Numberic_String_FromList();
		pObj.isNumber(alphaNum);

	}
	
}