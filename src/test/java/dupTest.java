import java.util.HashMap;
import java.util.Set;
import java.util.Map.*;
import java.util.*;

public class dupTest {

public static void main(String[] a) {

	String dup = "asdijasDHdy";
	
	HashMap<String, Integer> dupM = new HashMap<String, Integer>();
	
	String[] dupArray = dup.split("");
	for(String s: dupArray) {
		if(dupM.containsKey(s)) {
			dupM.put(s, dupM.get(s) + 1);
		}
		else {
			dupM.put(s, 1);
		}
	}
	
	Set<Entry<String, Integer>> entry = dupM.entrySet();
	
	for(Entry<String, Integer> me : entry) {
		System.out.println(me.getKey() + " : " + me.getValue());
	}
	
	
	Set en = dupM.entrySet();
	Iterator itr = en.iterator();
	while(itr.hasNext()) {
		
		Entry m = (Entry)itr.next();
		System.out.println(m.getKey() + " : " + m.getValue());
	}
}

}