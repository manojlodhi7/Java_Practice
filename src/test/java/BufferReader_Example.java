import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferReader_Example {

    public void reader(){
        try(BufferedReader br2 = new BufferedReader(new FileReader(""))){
            String line2 ="";
            while((line2 = br2.readLine()) != null){
                System.out.println(line2);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("C:\\Personal\\TestReader\\C2ImportFamRelSample.csv"));
        String line ="";
        while((line = br.readLine()) != null){
            System.out.println(line);
        }


    }
}
