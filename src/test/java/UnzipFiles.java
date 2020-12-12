import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnzipFiles {

    public static void main(String[] args) throws Exception {

        //PropertyClass prop=new PropertyClass();
        //String source_dir=prop.getPropValues("unzipInputPath");
        //String destDir=prop.getPropValues("unzipOutputPath");


        String source_dir="C:\\ZipProgramOutput\\Input";
        String destDir="C:\\ZipProgramOutput\\Output";


        System.out.println("unzipInputPath: " + source_dir);
        System.out.println("unzipOutputPath: " + destDir);


        File dir = new File(source_dir);
        File[] files = dir.listFiles();
        System.out.println("Files: " + files.length);

        System.out.println("********************************************** Start Unzipping.... **********************************************************");

        // String zipFilePath = "src\\test\\resources\\Input/2020_5_2_12_0_1.zip";
        //String destDir = "src\\test\\resources\\Output";
        String zipFilePath;
        for (File f : files)
        {
            zipFilePath=f.getAbsolutePath();

            unzip(zipFilePath, destDir);
            System.out.println("The given File "+zipFilePath+" Succesfully Unzipped at Location : "+destDir);
            System.out.println("********************************************** Successfully Unzipped *****************************************************");


        }
    }

    private static void unzip(String zipFilePath, String destDir) {
        File dir = new File(destDir);
        // create output directory if it doesn't exist
        if(!dir.exists()) dir.mkdirs();
        FileInputStream fis;
        //buffer for read and write data to file
        byte[] buffer = new byte[1024];
        try {
            fis = new FileInputStream(zipFilePath);
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry ze = zis.getNextEntry();
            while(ze != null){
                String fileName = ze.getName();
                File newFile = new File(destDir + File.separator + fileName);
                System.out.println("Unzipping to "+newFile.getAbsolutePath());
                //create directories for sub directories in zip
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                //close this ZipEntry
                zis.closeEntry();
                ze = zis.getNextEntry();
            }
            //close last ZipEntry
            zis.closeEntry();
            zis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}