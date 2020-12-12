import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class dynamoDbDelete {

    static Table tenantRegistryDynamoDBTable;
    static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
    static DynamoDB dynamoDB = new DynamoDB(client);

    public static boolean deleteDynamoDbItemsOfRequestHistoryStatusTable(String paramTableName) throws Exception {
        boolean deleteSuccess = false;

        List<String> copyAndProcessed = new ArrayList<>();

        String tenantID = "11ea2d67-7385-c750-9a4d-0242ac110002";

        String tableName = paramTableName;
        tenantRegistryDynamoDBTable = dynamoDB.getTable(tableName);

        ScanSpec scanSpec = new ScanSpec().withProjectionExpression("tenantId")
                    .withFilterExpression("TenantId = :tenantId")
                    .withValueMap(new ValueMap().withString(":tenantId", tenantID));


        ItemCollection<ScanOutcome> items = tenantRegistryDynamoDBTable.scan(scanSpec);

        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item i = iterator.next();
            //System.out.println(i);
            String copyAndProcessedData;
            if (tableName.contains("AwIfmADLServiceParquetConversionStatus")) {
                copyAndProcessedData = i.getString("BaseActivity");
                copyAndProcessed.add(copyAndProcessedData);
            } else {
               copyAndProcessedData = i.getString("RequestID");
                System.out.println(copyAndProcessedData);
               copyAndProcessed.add(copyAndProcessedData);
            }
        }

        System.out.println("Checking DynamoDB Table " + tableName + ": Table Record Size: " + copyAndProcessed.size());

        if (copyAndProcessed.size() > 0) {
            for (String RequestIDBaseActivity : copyAndProcessed) {
                System.out.println(RequestIDBaseActivity);
                DeleteItemSpec deleteItemSpec;
                if (tableName.contains("AwIfmADLServiceParquetConversionStatus")) {
                    System.out.println("****AwIfmADLServiceParquetConversionStatus Table Deletion Started****");
                    deleteItemSpec = new DeleteItemSpec().withPrimaryKey(
                            new PrimaryKey("BaseActivity", RequestIDBaseActivity, "TenantId", tenantID));

                } else {
                    System.out.println("****AwIfmADLServiceParquetConversionRequest and AwIfmADLServiceParquetConversionHistory Table Deletion Started****");
                    deleteItemSpec = new DeleteItemSpec()
                            .withPrimaryKey(new PrimaryKey("RequestID", RequestIDBaseActivity));
                }

                try {
                    System.out.println("Attempting one by one conditional delete operation.....!!");
//                    tenantRegistryDynamoDBTable.deleteItem(deleteItemSpec);
                    System.out.println("The DynamoDB Table Name: " + tableName + " Item Deletion operation has succesfully done....!!");
                    deleteSuccess = true;
                } catch (Exception e) {
                    System.err.println("For given Table: " + tableName + ": Unable to delete item record for RequestID : "
                            + RequestIDBaseActivity);
                    deleteSuccess = false;
                    System.err.println(e.getMessage());
                }
            }
        } else {
            deleteSuccess = true;
            System.out.println("For given Table: " + tableName + " No record found for the given tenant " + tenantID);
        }

        return deleteSuccess;
    }


    public static void main(String[] args) throws Exception {
        deleteDynamoDbItemsOfRequestHistoryStatusTable("AwIfmADLServiceParquetConversionHistoryTest");
//        deleteDynamoDbItemsOfRequestHistoryStatusTable("AwIfmADLServiceParquetConversionStatusTest");
//        deleteDynamoDbItemsOfRequestHistoryStatusTable("AwIfmADLServiceParquetConversionRequest");
    }
}
