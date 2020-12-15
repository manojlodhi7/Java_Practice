import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class awsS3 {

    AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
            .withRegion(Regions.US_EAST_1)
            .withCredentials(new ProfileCredentialsProvider())
            .build();


    public void deleteObjects(String bucketName, String objLocation) throws Exception {
        String currentDirectory = System.getProperty("user.dir");
        ObjectListing objectListing = s3Client.listObjects(bucketName, objLocation);
        if(objectListing.getObjectSummaries().size() > 0){
            System.out.println("objectListing.getObjectSummaries().size() " + objectListing.getObjectSummaries().size());
            for(S3ObjectSummary os : objectListing.getObjectSummaries()) {
                String filePath = os.getKey();
                System.out.println("filePath : " + filePath);
                String[] fileNames = filePath.split("/");
                S3Object s3object = s3Client.getObject(bucketName, filePath);
                S3ObjectInputStream inputStream = s3object.getObjectContent();
                FileUtils.copyInputStreamToFile(inputStream, new File(currentDirectory + fileNames[fileNames.length-1]));
//                CSVReaderWriteUtilityMain.callCSVChangeData("ADL", currentDirectory + fileNames[fileNames.length-1], "2019");
//                s3Client.putObject(
//                        bucketName,
//                        "962400859/6894_F_24M23/AW_IFM/IFMStaging/E2E/s3Csv.csv",
//                        new File(currentDirectory + "/s3Csv.csv")
//                );
            }
        }

    }

    public static void main(String[] args) throws Exception, IOException {
        awsS3 obj = new awsS3();
        obj.deleteObjects("xsight-data-lake-us-east-1-test", "962400859/6894_F_24M23/AW_IFM/IFMStaging/TuningLog/M_DCK_D/2020-03-30/");
    }


}
