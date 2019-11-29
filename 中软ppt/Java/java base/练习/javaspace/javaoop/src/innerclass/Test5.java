package innerclass;

import java.util.Arrays;
import java.util.Comparator;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book[] bookArr = new Book[]{
			new Book(1,"十万个为什么",300),
			new Book(2,"十个为什么",30),
			new Book(3,"西游记",99),
			new Book(4,"java入门",45),
			new Book(5,"html5",45)
		};
	
		Arrays.sort(bookArr, new Comparator(){
			/**
			 * 比较数组中的值是否需要进项交换，返回值大于0进行交换，否则不交换
			 */
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				Book b1 = (Book)o1;
				Book b2 = (Book)o2;
				if(b1.getPrice() == b2.getPrice()){
					return b1.getId() - b2.getId();
				}else if(b1.getPrice()<b2.getPrice()){
					return 1;
				}else{
					return -1;
				}
			}
		});
		for(Book b :bookArr){
			System.out.println(b);
		}
		
	}

}
