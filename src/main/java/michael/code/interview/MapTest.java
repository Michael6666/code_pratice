package michael.code.interview;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("1","Tom1");
		map.put("2","Tom2");
		map.put("3","Tom3");
//		for(String str : map.keySet()) {
//			System.out.println(str+"---"+map.get(str));
//		}
		
		Iterator<Entry<String, String>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Entry entry = it.next();
			System.out.println(entry.toString());
		}
	}

}
