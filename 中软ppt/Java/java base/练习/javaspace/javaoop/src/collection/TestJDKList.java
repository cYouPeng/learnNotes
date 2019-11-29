package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestJDKList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new LinkedList<String>();
		list.add("a");
		list.add("b");
		list.add("c");

		
//		List childList = new ArrayList();
//		childList.add("hello");
//		childList.add("world");
//		list.addAll(1, childList);
//		System.out.println("init:"+list.isEmpty()+list.size());
//		list.add("hello");
//		list.add("word");
//		list.add(1, "haha");
//		list.remove(0);
//		String str = (String)list.get(0);
//		list.set(0, str.toUpperCase());
		
//		for(int i=0; i<list.size(); i++){
//			String s = (String)list.get(i);
//			System.out.println(s);
//		}
		
		for(String s : list){
			System.out.println(s);
		}
	}

}
