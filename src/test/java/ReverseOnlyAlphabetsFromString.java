public class ReverseOnlyAlphabetsFromString {

    public static void reverse(String str) {
        String[] strA = str.split("[^a-zA-Z]+");
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<strA.length; i++){
			System.out.println("strA[i] - " + strA[i]);
            sb.append(strA[i]);
        }
//		System.out.println(sb);
        sb.reverse();
//		System.out.println(sb);
        for(int i = 0; i<str.length(); i++){
            if(!(Character.isAlphabetic(str.charAt(i)))) {
//				System.out.println( sb + " : " + i + " : " + str.charAt(i));
                sb.insert(i, str.charAt(i));
            }
        }

        System.out.println("Input  : " + str);
        System.out.println("Output : " + sb);
    }

    public static void main(String[] s2) {

        reverse("sf#@rq&*j45pk87d");

    }
}
