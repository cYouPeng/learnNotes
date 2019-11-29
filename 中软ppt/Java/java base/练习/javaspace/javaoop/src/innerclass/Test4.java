package innerclass;

import java.util.Arrays;
import java.util.Comparator;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"hello","abc","abcd","ac","aaaa"};
		Arrays.sort(strs, new Comparator(){

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				String s1 = (String)o1;
				String s2 = (String)o2;
				if(s1.length()==s2.length()){
					return s1.compareTo(s2);
				}
				return s1.length()-s2.length();
			}
			
		});
		
		for(String s : strs){
			System.out.println(s);
		}
	}

}
