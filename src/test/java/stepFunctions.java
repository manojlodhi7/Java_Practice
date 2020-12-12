import static com.amazonaws.services.stepfunctions.builder.StepFunctionBuilder.*;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.stepfunctions.AWSStepFunctions;
import com.amazonaws.services.stepfunctions.AWSStepFunctionsClientBuilder;
import com.amazonaws.services.stepfunctions.builder.ErrorCodes;
import com.amazonaws.services.stepfunctions.builder.StateMachine;
import com.amazonaws.services.stepfunctions.model.DescribeActivityRequest;
import com.amazonaws.services.stepfunctions.model.DescribeActivityResult;


public class stepFunctions {

    public static void main(String[] args) {
        final AWSStepFunctions client = AWSStepFunctionsClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .build();
        DescribeActivityResult result =  client.describeActivity(new DescribeActivityRequest().withActivityArn("arn:aws:states:us-east-1:714957386617:execution:AwIfmDataPipelineSfnTest:MODEL_PERFORMANCE_REPORT-20200612-0455-11ea2d67-7385-c750-9a4d-0242ac110002"));

        System.out.println(result.toString());

    }
}
