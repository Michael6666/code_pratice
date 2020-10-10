package michael.code.interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionTest {

	public static void main(String[] args) {
		List<String> a = new ArrayList<>();
		a.add("����");
		a.add("����");
		a.add("����");
//		a.remove("����");
//		System.out.println(a.toString());
//		for(String str : a) {
//			if("����".equals(str)) {
//				a.remove(str);
//			}
//		}
		
		Iterator<String> it = a.iterator();
		while(it.hasNext()) {
			String str = it.next();
			if(str.equals("����")) {
				it.remove();
			}
		}
		System.out.println(a.toString());
	}

}
