package collection;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class TestJdkMap {
	public static void main(String[] args){
//		List list= new ArrayList();
//		list.add(new Student("2018001","zhangsan"));
//		list.add(new Student("2018011","lisi"));
//		list.add(new Student("2018100","wangwu"));
//		list.add(new Student("2018123","zhaoliu"));
//		Student s = null;
//		for(int i=0; i<list.size(); i++){
//			Student temp = (Student)list.get(i);
//			if("lisi".equals(temp.getName())){
//				s = temp;
//				break;
//			}
//		}
		
		
		Map map = new LinkedHashMap();
		map.put("zhangsan", new Student("2018001","zhangsan"));
		map.put("lisi", new Student("2018011","lisi"));
		map.put("wangwu", new Student("2018100","wangwu"));
		map.put("zhaoliu", new Student("2018123","zhaoliu"));
		
//		Scanner input = new Scanner(System.in);
//		String key = input.next();
//		Student stu = (Student)map.get(key);
//		System.out.println(stu);
		
		Set keySet = map.keySet();//将map中所有的key组装到set集合中，并返回这个set集合
		//low的遍历set的方案
//		Object[] keys = keySet.toArray();//将set转存成一个数组
//		for(Object key: keys){
//			Student s = (Student)map.get(key);
//			System.out.println(s);
//		}
		//优选的方案
		Iterator iterator = keySet.iterator();
		while(iterator.hasNext()){
			Object key = iterator.next();//取出迭代器所指向的下一个元素，迭代器指向下个
			String s = (String)map.get(key);
			System.out.println(s);
		}
//		
//		Object key = iterator.next();//取出迭代器所指向的下一个元素，迭代器指向下个
	}

}

class Student{
	private String id;
	private String name;
	public Student(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
}
