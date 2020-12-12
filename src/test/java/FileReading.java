import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReading {

    public static void main(String[] ar) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(""));
        String str;
        while ((str = br.readLine()) != null){
            System.out.println(str);
        }

    }
}
