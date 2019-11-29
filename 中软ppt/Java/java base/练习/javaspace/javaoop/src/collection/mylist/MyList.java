package collection.mylist;

public interface MyList {
	int size();
	boolean isEmpty();
	void clear();
	
	void add(Object value);
	void add(Object value, int index);
	
	void delete(int index);
	
	void set(Object value, int index);
	
	Object get(int index);
}
