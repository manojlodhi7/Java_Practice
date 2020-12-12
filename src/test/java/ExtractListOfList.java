import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExtractListOfList {
    public static void listOflist(List<Integer> iList) {
// *********************  Input List<Integer> ar = Arrays.asList(1, 2, 3, 4, 5, 6, 3, 4, 5, 6, 5, 6, 7, 8, 4, 5, 6);
// *********************  Output = [[1, 2, 3, 4, 5, 6], [3, 4, 5, 6], [5, 6, 7, 8], [4, 5, 6]]
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        temp.add(iList.get(0));

        for(int i = 1; i<iList.size(); i++){
            if(iList.get(i) > iList.get(i-1)) {
                temp.add(iList.get(i));
            }
            else if(iList.get(i) < iList.get(i-1)) {
// ***************  Cloning is very important here, otherwise it will clear all previous entries of temp list
                mainList.add((ArrayList<Integer>) temp.clone());
                temp.clear();
                temp.add(iList.get(i));
            }
        }
        mainList.add(temp);

        System.out.println(mainList);
    }

    public static void main(String[] s2) {
        Integer[] iArray = {1, 2, 3, 4, 5, 6, 3, 4, 5, 6, 5, 6, 7, 8, 4, 5, 6};
        List<Integer> ar = Arrays.asList(iArray);
        listOflist(ar);
    }

}
