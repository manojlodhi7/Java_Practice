import org.apache.hadoop.fs.Path;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CurlRunner {




    public void csvWritter(ArrayList<String> rprt) {
            try {
                File file = new File("report.csv");
                if(!file.exists()) {
                    file.createNewFile();
                } else {
                    file.delete();
                    file.createNewFile();
                }

                PrintWriter pw = new PrintWriter(new FileWriter(file));
                for(String s: rprt) {
                    pw.println(s);
                }
                pw.flush();
                pw.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void csvReader(String message, String result) {
        ArrayList<String> hm = new ArrayList<>();
        if(message != null && !message.equals("")) {
            try(BufferedReader br= new BufferedReader(new FileReader("report.csv"))) {
                String s = br.readLine();
                while(s != null) {
                    System.out.println(s);
                    if(s.contains(message)) {
                        hm.add(s.split(",")[0] + ", " + result);
                        System.out.println(s.split(",")[0]);
                    } else {
                        hm.add(s);
                    }
                    s = br.readLine();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            csvWritter(hm);

        }
    }

    public void uploadData() { //String cpCommnad, String localInputPath
        String command = "aws s3 cp C:/Users/mlodhi/Desktop/Destination/CDS_V_COUNTRY_20190619-080536_161.zip s3://xsight-data-lake-us-east-1-test/662023/e...36on6c31/com.actimize.awSam.dataIngestion/TestingData/ --sse";
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        processBuilder.directory(new File("/C:\\Users\\mlodhi\\Desktop\\Destination"));
        Process process = null;
        try {
            process = processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream inputStream = process.getInputStream();

        BufferedReader reader =  new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String line = null;
        while (true) {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            builder.append(line);
            builder.append(System.getProperty("line.separator"));
        }
        String result = builder.toString();
        System.out.print(result);

        process.destroy();
    }







    public static void main(String[] args) throws IOException {
//        String command = "curl -X GET https://landing-zone.dev.actimize-afcm.cloud/landing-zone/v1/ex-8aUDPQar/com.actimize.awSam.dataIngestion/unprocessed?dataType=xdt-CDS-V_BUSINESS_UNIT";
//        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
//        processBuilder.directory(new File("/C:\\Users\\mlodhi\\Desktop\\Destination"));
//        Process process = processBuilder.start();
//        InputStream inputStream = process.getInputStream();
//
//        BufferedReader reader =  new BufferedReader(new InputStreamReader(process.getInputStream()));
//        StringBuilder builder = new StringBuilder();
//        String line = null;
//        while ( (line = reader.readLine()) != null) {
//            builder.append(line);
//            builder.append(System.getProperty("line.separator"));
//        }
//        String result = builder.toString();
//        System.out.print(result);
//
//        process.destroy();


//        String message = "Reporting - Start Reporting service"; // System.getProperty("msg");
//        String result = "failed";  // System.getProperty("rslt");
        CurlRunner cr = new CurlRunner();
//        cr.csvWritter(cr.reportTemplate());
//
//        cr.csvReader(message, result);
//        cr.csvReader("Register - Invoke AW 2.0 SAM Register service ", "Success");
//        cr.csvReader("XDT upload - Verify XDT uploaded data to XSight extern", "No Result");
//        cr.csvReader("DataIngestion - Verify files are copied at staging locat", result);


        cr.uploadData();

    }



}
