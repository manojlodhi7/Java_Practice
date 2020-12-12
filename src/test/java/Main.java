import jdk.nashorn.internal.parser.JSONParser;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

 /*   String hh;
    String mm;
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
    String strDate = formatter.format(date);
        System.out.println("strDate : " + strDate);
    String[] dArray = strDate.split(" ")[1].split(":");
        if(Integer.valueOf(dArray[1]) > 15) {
        hh = dArray[0];
        mm = String.valueOf(Integer.valueOf(dArray[1]) - 15);
    } else {
        if(Integer.valueOf(dArray[0]) - 1 == 0) {
            hh = "12";
        } else hh = String.valueOf(Integer.valueOf(dArray[0]) - 1);
        mm = String.valueOf(60 - (15 -Integer.valueOf(dArray[1])));
    }
    String newDateTime = strDate.split(" ")[0] + " " + hh + ":" + mm + ":" + dArray[2];
        System.out.println("newDateTime : " + newDateTime);
        */


    List<String> filePaths = new ArrayList<String>();
    List<String> curlCommandList = new ArrayList<String>();
    Map<String, String> curlResult= new HashMap<String, String>();
    String filePath = "C:/Users/mlodhi/Desktop/Test2/RDBMS";
    String filePathDestination = "C:/Users/mlodhi/Desktop/Destination";
    File destination = new File(filePathDestination);
    File source;


    public void copyZip() throws IOException {
        File folder = new File(filePath);
        File[] listOfFolders = folder.listFiles();

        for (int i = 0; i < listOfFolders.length; i++) {
            if (listOfFolders[i].isDirectory()) {

                String newFilePath = filePath + "/" + listOfFolders[i].getName();

                File subFolder = new File(newFilePath);
                File[] listOfSubFolders = subFolder.listFiles();

                for (int j = 0; j < listOfSubFolders.length; j++) {
                    if (listOfSubFolders[j].isDirectory()) {
                        String zipFilePath = newFilePath + "/" + listOfSubFolders[j].getName() + "/Zip";
                        filePaths.add(zipFilePath);
                    }
                }
            }
        }

        if (filePaths.size() != 0) {
            for (int i = 0; i < filePaths.size(); i++) {
                source = new File(filePaths.get(i));
                File[] listOfFiles = source.listFiles();
                for (int k = 0; k < listOfFiles.length; k++) {
                    if (listOfFiles[k].isFile()) {
                        FileUtils.copyDirectory(source, destination);
                    }
                }
            }

        }
    }

    public void createURLs(String tenatId, String env) {
        File folder = new File(filePathDestination);
        File[] listOfFile = folder.listFiles();
        for (int i = 0; i < listOfFile.length; i++) {
            if (listOfFile[i].isFile()) {
                String fileName = listOfFile[i].getName();
                String[] fileList = fileName.split("_");
                if (fileList[0].contains("CDS")) {
                    String[] s = fileName.split("CDS_V_");
                    String[] s1 = s[1].split("_2019");
                    System.out.println("aws s3 cp " + listOfFile[i].getName() + " s3://xsight-external-us-east-1-" + env + "/home/" + tenatId + "/xdt-CDS-V_" + s1[0] + "/ --sse");
                    curlCommandList.add("curl -X GET https://landing-zone." + env + ".actimize-afcm.cloud/landing-zone/v1/" + tenatId + "/com.actimize.awSam.dataIngestion/unprocessed?dataType=xdt-CDS-V_" + s1[0]);
                }
                if (fileList[0].contains("SAM") && fileList[1].contains("APP")) {
                    String[] s = fileName.split("SAM_APP_TG_V_");
                    String[] s1 = s[1].split("_2019");
                    System.out.println("aws s3 cp " + listOfFile[i].getName() + " s3://xsight-external-us-east-1-" + env + "/home/" + tenatId + "/xdt-SAM_APP_TG-V_" + s1[0] + "/ --sse");
                    curlCommandList.add("curl -X GET https://landing-zone." + env + ".actimize-afcm.cloud/landing-zone/v1/" + tenatId + "/com.actimize.awSam.dataIngestion/unprocessed?dataType=xdt-SAM_APP_TG-V_" + s1[0]);
                }
                if (fileList[0].contains("SAM") && fileList[1].contains("IDW")) {
                    String[] s = fileName.split("SAM_IDW_TG_V_");
                    String[] s1 = s[1].split("_2019");
                    System.out.println("aws s3 cp " + listOfFile[i].getName() + " s3://xsight-external-us-east-1-" + env + "/home/" + tenatId + "/xdt-SAM_IDW_TG-V_" + s1[0] + "/ --sse");
                    curlCommandList.add("curl -X GET https://landing-zone." + env + ".actimize-afcm.cloud/landing-zone/v1/" + tenatId + "/com.actimize.awSam.dataIngestion/unprocessed?dataType=xdt-SAM_IDW_TG-V_" + s1[0]);
                }
                if (fileList[0].contains("SAM") && fileList[1].contains("PRF")) {
                    String[] s = fileName.split("SAM_PRF_TG_V_");
                    String[] s1 = s[1].split("_2019");
                    System.out.println("aws s3 cp " + listOfFile[i].getName() + " s3://xsight-external-us-east-1-" + env + "/home/" + tenatId + "/xdt-SAM_PRF_TG-V_" + s1[0] + "/ --sse");
                    curlCommandList.add("curl -X GET https://landing-zone." + env + ".actimize-afcm.cloud/landing-zone/v1/" + tenatId + "/com.actimize.awSam.dataIngestion/unprocessed?dataType=xdt-SAM_PRF_TG-V_" + s1[0]);
                }
                if (fileList[0].contains("RCM")) {
                    String[] s = fileName.split("RCM_TG_V_");
                    String[] s1 = s[1].split("_2019");
                    System.out.println("aws s3 cp " + listOfFile[i].getName() + " s3://xsight-external-us-east-1-" + env + "/home/" + tenatId + "/xdt-RCM_TG-V_" + s1[0] + "/ --sse");
                    curlCommandList.add("curl -X GET https://landing-zone." + env + ".actimize-afcm.cloud/landing-zone/v1/" + tenatId + "/com.actimize.awSam.dataIngestion/unprocessed?dataType=xdt-RCM_TG-V_" + s1[0]);
                }


            }
        }

    }

    public void curlRunner()throws IOException  {
        if(curlCommandList.size() != 0) {
            for(int i =0; i<curlCommandList.size() ; i++) {
//                String command = "curl -X GET https://landing-zone.dev.actimize-afcm.cloud/landing-zone/v1/ex-8aUDPQar/com.actimize.awSam.dataIngestion/unprocessed?dataType=xdt-CDS-V_BUSINESS_UNIT";
                String command = curlCommandList.get(i);
                System.out.println(command);
                ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
                processBuilder.directory(new File("/C:\\Users\\mlodhi\\Desktop\\Destination"));
                Process process = processBuilder.start();
                InputStream inputStream = process.getInputStream();

                BufferedReader reader =  new BufferedReader(new InputStreamReader(process.getInputStream()));
                StringBuilder builder = new StringBuilder();
                String line = null;
                while ( (line = reader.readLine()) != null) {
                    builder.append(line);
                    builder.append(System.getProperty("line.separator"));
                }
                String result = builder.toString();
//                System.out.print(result);
                process.destroy();
                String[] dataTypes = command.split("=");
                if(result.contains(".parquet\"")) {
                    curlResult.put(dataTypes[1],".parquet Present");
                } else {
                    curlResult.put(dataTypes[1],".parquet Not Present");
                }
            }
        }

        Set<String> set = curlResult.keySet();
        Iterator<String> itr = set.iterator();
        while(itr.hasNext()) {
            String s = itr.next();
            System.out.println(s + " parquet status: " + curlResult.get(s));
        }

    }


     public void reNameFiles(String newDate, String time) {
         File folder = new File(filePathDestination);
         File[] listOfFile = folder.listFiles();
         for (int i = 0; i < listOfFile.length; i++) {
             if (listOfFile[i].isFile()) {
                 String fileName = listOfFile[i].getName();
                 String[] fName = fileName.split("2019");
                 File file = new File(filePathDestination + "\\"+fileName);
                 File file2 = new File(filePathDestination + "\\"+fName[0] + newDate + "-" + time + "_161.zip"); // 20190619-080528_161
                 if(!fName[0].contains("run.sh")) {
                     file.renameTo(file2);
                 }
//                 boolean b = file.renameTo(file2);
//                 System.out.println("1: " + fileName + "\n2: " + file2.getName() + "\n   " + b);
//                 File file2 = new File(fName[0]);

             }
         }
     }
    public static void main(String[] args) throws IOException, JSONException {

        String tenatId = "ex-8aUDPQar";
        String env = "dev";
//        String date = "20190720"; // YYYY-MM-DD
        String time = "080528"; //

        Main mObj = new Main();

        /* Copy all zips to single destination folder*/
        mObj.copyZip();

        /* To create upload URLs*/
//        mObj.createURLs(tenatId, env);

        /* To get curl URLs  response run createURLs + curlRunner*/
//        mObj.curlRunner();

        /* to rename all zip files  YYYY-MM-DD*/
//        mObj.reNameFiles(date, time);


//        JSONParser parser = new JSONParser(env,);
//        JSONObject json = (JSONObject) parser.parse(env);
//        JSONObject json = new JSONObject(env);   /Desktop/Destination




    }
}
