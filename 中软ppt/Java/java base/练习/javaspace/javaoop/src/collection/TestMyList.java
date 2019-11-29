package collection;

import collection.mylist.MyList;
import collection.mylist.MyListImp;

public class TestMyList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyList list = new MyListImp();
		System.out.println(list.size());
		
		list.add("hello");
		list.add("world");
		list.add("aaaa",0);
		list.add("bbb",2);
		
		
		for(int i=0; i<list.size();i++){
			System.out.println(list.get(i));
		}
		list.delete(0);
		list.set("hahaha", 0);
		for(int i=0; i<list.size();i++){
			System.out.println(list.get(i));
		}
	}

}
