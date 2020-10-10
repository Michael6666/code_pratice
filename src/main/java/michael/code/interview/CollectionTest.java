package michael.code.interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionTest {

	public static void main(String[] args) {
		List<String> a = new ArrayList<>();
		a.add("张三");
		a.add("李四");
		a.add("王五");
//		a.remove("张三");
//		System.out.println(a.toString());
//		for(String str : a) {
//			if("张三".equals(str)) {
//				a.remove(str);
//			}
//		}
		
		Iterator<String> it = a.iterator();
		while(it.hasNext()) {
			String str = it.next();
			if(str.equals("张三")) {
				it.remove();
			}
		}
		System.out.println(a.toString());
	}

}
