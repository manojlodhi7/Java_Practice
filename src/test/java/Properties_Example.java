import java.io.*;
import java.util.Properties;

public class Properties_Example {
    public static void main(String[] ar) throws IOException {
        String currentDirectory = System.getProperty("user.dir");
        String filePath = currentDirectory + "/properties/propFileName";

        Properties p = new Properties();
        p.load(new BufferedReader(new FileReader("filePath")));
        String name = p.getProperty("name");
        p.setProperty("name", "value");
        p.store(new BufferedWriter(new FileWriter("filePath")), "");


        FileInputStream fis = new FileInputStream(filePath);
        Properties pNew = new Properties();
        pNew.load(fis);
        pNew.getProperty("something");
        fis.close();
        pNew.setProperty("abc", "xyz");
        FileOutputStream fos = new FileOutputStream(filePath);
        pNew.store(fos, "some comments");

    }
}
