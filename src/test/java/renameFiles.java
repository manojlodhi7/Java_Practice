import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class renameFiles {


    String filePathDestination = "C:/Users/mlodhi/Desktop/Tuning/Data/8_20190125_191240 - Origonal"; // C:\Users\mlodhi\Desktop\Tuning\Data\8_20190125_191240\20141006

    public void reNameFiles11(String newDateTime) {
        File folder = new File(filePathDestination);
        System.out.println(folder);
        File[] listOfDir = folder.listFiles();
        System.out.println(listOfDir.length);
        for (int i = 0; i < listOfDir.length; i++) {
            if(listOfDir[i].isDirectory()) {
                String dirName = filePathDestination + "/" + listOfDir[i].getName();
                File[] listOfFile = (new File(dirName)).listFiles();
                System.out.println( "listOfFile " + listOfFile.length);
                System.out.println( "dirName " + dirName);
                for(int j = 0; j < listOfFile.length; j++) {
                    if (listOfFile[j].isFile()) {
                        String fileName = listOfFile[j].getName();
//                        System.out.println( "fileName " + dirName + "/"+fileName);

//                        System.out.println( "fileName " + fName[1]);
                        if(!fileName.contains("s8n_exchange_rates.csv")) {
                            String[] fName = fileName.split("191240");
                            File file = new File(dirName + "/"+fileName);
                            File file2 = new File(dirName + "/" + newDateTime + fName[1]); // 20190619-080528_161
                            file.renameTo(file2);
                        }
                    }
                }

            }

        }
    }



    public void reNameFiles_02(String newDateTime) {
        String filePath = "C:\\Users\\mlodhi\\Desktop\\IFM\\TuningLog_MinimalData";

        File folder = new File(filePath);
//        System.out.println(folder);
        File[] listOfDir = folder.listFiles();
//        System.out.println(listOfDir.length);
        for (int i = 0; i < listOfDir.length; i++) {
            if(listOfDir[i].isDirectory()) {
//                System.out.println( "Inside BA " );
                String dirName = filePath + "/" + listOfDir[i].getName();
//                System.out.println( "dirName " + dirName);
                String baName = dirName.split("/")[1];
                File[] listOfFile = (new File(dirName)).listFiles();
//                System.out.println( "dirName list length " + listOfFile.length);


            for(int k = 0; k<listOfFile.length; k++) {
                if(listOfFile[k].isDirectory()) {
//                    System.out.println( "Inside Date " );
                    String dirname[] = listOfFile[k].getName().split("/");

//                    System.out.println( "listOfFile " + listOfFile.length);
                    String dateName = dirname[dirname.length-1].replace("-", "_");
                    String dateName2 = dirname[dirname.length-1];
//                    System.out.println( "FileName " + dateName);
                    String dateDirName = dirName + "/" + listOfFile[k].getName();
//                    System.out.println( "dateDirName " + dateDirName);
                    File[] listOfDateFile = (new File(dateDirName)).listFiles();

                    for(int j = 0; j < listOfDateFile.length; j++) {
//                        System.out.println("Ok");
                        if (listOfDateFile[j].isFile()) {
//                            System.out.println( "Inside csv File " );
                            String fileName = listOfDateFile[j].getName();
//                            System.out.println( "fileName " + dateDirName + "/"+fileName);

//                        System.out.println( "fileName " + fName[1]);
                            if(fileName.contains(dateName)) {
                                String[] fName = fileName.split(dateName);
                                String[] ssplit = fileName.split("_");
                                String HeaderKey = ssplit[ssplit.length-2];

                                System.out.println(  "\"RequestID\" : " + "\"978813004_" + baName + "_"+dateName2+"_"+HeaderKey +"\"," + "   \"BaseActivity\" : " + "\"" + baName + "\"," +  "  \"ExecutionDate\" :  " + "\"" + dateName2 + "\"," + "        \"HeaderKey\" : " + "\"" + HeaderKey + "\"," + "   \"InputPath\" : " + "\"/IFMStaging/TuningLog/"+baName+"/" + dateName2 + "/\"," + "   \"FileType\": \"ADL\", \"TuningConfigPath\": \"NA\",   \"TenantId\": \"978813004\", \"Status\": \"Unprocessed\"" );
//                                File file = new File(dateDirName + "/"+fileName);
//                                File file2 = new File(dateDirName + "/" + fName[0] + newDateTime + fName[1]); // 20190619-080528_161
//                                System.out.println("output file Name : " + dateDirName + "/" + fName[0] + newDateTime + fName[1]);
//                                file.renameTo(file2);
                            }
                        }
                    }

                }
            }









            }

        }
    }


    public static void main(String[] r) {
        renameFiles obj = new renameFiles();
        obj.reNameFiles_02("2020_01_20"); // 2020-01-20
    }
}
