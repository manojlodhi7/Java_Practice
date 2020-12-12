import java.util.*;


public class BinaryToDecimalConversion {


    static int binaryToDecimal(int n)
    {
        int num = n;
        int dec_value = 0;

        // Initializing base
        // value to 1, i.e 2^0
        int base = 1;

        int temp = num;
        while (temp > 0) {
            int last_digit = temp % 10;
            temp = temp / 10;
            dec_value += last_digit * base;
            System.out.println("last_digit : " + last_digit + " temp " + temp + " dec_value " + dec_value + " base " + base);
            base = base * 2;
        }

        return dec_value;
    }

    public static void main(String[] arg){
//        int num = 10101001;
        int num = 101;
        System.out.println(binaryToDecimal(num));

        /*
        String[] sArray = "1010".split("");
		int decimal = 0;
		int counter = 0;
		for(int i = sArray.length-1; i>=0; i--){
			if(!sArray[i].equals("0")){
				decimal += Math.pow(2, counter);
			}
			counter++;
		}
		System.out.println(decimal);
		*/

    }
}
