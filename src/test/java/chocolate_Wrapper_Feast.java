public class chocolate_Wrapper_Feast {
    public static int chocolateFeast(int money, int cost, int free){
//        total money = 15
//        cost per choc = 1 rs
//        3 wrapper = 1 choc
        int chocolates = money / cost;
        if (chocolates >= free){
            int wrappers = chocolates;
            while (wrappers > 0){
                wrappers = wrappers - free;
                if (wrappers >= 0){
                    chocolates += 1;
                    wrappers += 1;
                }
            }
        }
        return chocolates;
    }

    public static void chocolateFeast() {
        int totalMoney = 8;
        int chocCost = 1;
        int totalWrapperPerChoc = 3;
        int wrapper = 0;
        int totalChoc = 0;

        while(totalMoney>chocCost-1){
            totalMoney = totalMoney - chocCost;
            totalChoc++;
            wrapper++;
            if(wrapper==totalWrapperPerChoc){
                totalChoc++;
                wrapper = 1;
            }
        }
        System.out.println(totalChoc);
    }
    public static void main(String[] args) {

        System.out.println(chocolateFeast(8,1,3));

    }
}
