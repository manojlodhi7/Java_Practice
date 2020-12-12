import com.amazonaws.regions.Regions;
import com.amazonaws.services.autoscaling.AmazonAutoScaling;
import com.amazonaws.services.autoscaling.AmazonAutoScalingClientBuilder;
import com.amazonaws.services.autoscaling.model.UpdateAutoScalingGroupRequest;
import com.amazonaws.services.autoscaling.model.UpdateAutoScalingGroupResult;

public class aws {

    AmazonAutoScaling client = AmazonAutoScalingClientBuilder.standard().withRegion(Regions.US_EAST_1).build();

    public void updateAutoScalingConfig(int minSize, int maxSize, int desiredCapacity){
        UpdateAutoScalingGroupRequest request = new UpdateAutoScalingGroupRequest().withAutoScalingGroupName("AW_IFM_ENS_AUTO_SCALING")
                .withMinSize(minSize)
                .withMaxSize(maxSize)
                .withDesiredCapacity(desiredCapacity);
        UpdateAutoScalingGroupResult response = client.updateAutoScalingGroup(request);
    }

}



