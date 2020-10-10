package michael.code.interview;

import java.util.ArrayList;
import java.util.List;

public class DichotomyTest {

	public static void main(String[] args) {
		int[] a = {1,22,33,44,55,55,66,77,88};
		
		int b = 55;
		
		System.out.println(search(a, 0, a.length-1, b));
	}

	private static List<Integer> search(int[] a, int left, int right, int value) {
		List<Integer> bList = new ArrayList<>();
		int mid = (left + right)/2;
		if(left>right) {
			bList.add(-1);
			return bList;
		}else {
			if(a[mid]> value) {
				return search(a, left, mid-1, value);
			}else if(a[mid]< value) {
				return search(a, mid+1, right, value);
			}else {
				bList.add(mid);
				int leftTemp = mid-1;
				while(true) {
					if(leftTemp<0 || a[mid]!=a[leftTemp]) {
						break;
					}
					bList.add(leftTemp);
					leftTemp--;
				}
				
				int rightTemp = mid+1; 
				while(true) {
					if(rightTemp>a.length || a[mid]!=a[rightTemp]) {
						break;
					}
					bList.add(rightTemp);
					rightTemp++;
				}
				return bList;
			}
		}
		
	}
	
	

}
