public class ClimbingWallProblem {

    public static void main(String[] arg) {
        int totalStaires = 30;
        int DayUpSteps = 3;
        int nightDownSteps = 2;

        int DayTaken = 0;
        while(totalStaires>DayUpSteps){
            totalStaires = totalStaires - DayUpSteps + nightDownSteps;
            DayTaken++;
        }

        DayTaken++;
        System.out.println(DayTaken);
    }

}
