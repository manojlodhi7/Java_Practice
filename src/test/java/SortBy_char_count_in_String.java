import java.util.*;

public class SortBy_char_count_in_String implements Comparator<Object>{
    @Override
    public int compare(Object o1, Object o2) {
        String s1 = o1.toString();
        String s2 = o2.toString();
        return s1.compareTo(s2);
    }

    public static void main(String[] args) {
        String[] str = "aaaaaabbccccdddddddd".split(""); // Output : bcad
        HashMap<String, Integer> map = new HashMap<>();
        for(String s: str){
            if(map.containsKey(s)){
                map.put(s, (map.get(s)+1));
            }
            else {
                map.put(s, 1);
            }
        }

        Collection<Integer> c = map.values();
        ArrayList<Integer> l = new ArrayList<>(c);
        System.out.println(l);
        Collections.sort(l);


        for(Integer i: l){
            for(Map.Entry<String, Integer> me : map.entrySet()){
                if(i.equals(me.getValue())){
                    System.out.println(me.getKey());
                }
            }
        }

    }
}
