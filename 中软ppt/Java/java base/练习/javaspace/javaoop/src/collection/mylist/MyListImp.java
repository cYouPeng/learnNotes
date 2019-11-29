package collection.mylist;

public class MyListImp implements MyList{
	private final Node first;
	private final Node end;
	public MyListImp(){
		this.first = new Node();
		this.end = new Node();
		first.next = end;
		
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		int num = 0;
		Node currNode = this.first.next;
		while(currNode!=end){
			num++;
			currNode = currNode.next;
		}
		return num;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return first.next==end;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		first.next = end;
	}
	
	public void addFirst(Object value) {
		// TODO Auto-generated method stub
		this.addNode(first, value);
	}
	@Override
	public void add(Object value) {
		// TODO Auto-generated method stub
		if(this.size()==0){
			this.addFirst(value);
			return;
		}
		this.add(value, this.size());
	}
	@Override
	public void add(Object value, int index) {
		// TODO Auto-generated method stub
		if(index<0||index>this.size()){
			throw new IndexOutOfBoundsException();
		}
		if( index == 0 ){
			this.addFirst(value);
			return;
		}
		Node node = this.findNode(index-1);
		this.addNode(node, value);
		
	}
	@Override
	public void delete(int index) {
		// TODO Auto-generated method stub
		if(index<0||index>=this.size()){
			throw new IndexOutOfBoundsException();
		}
		Node preNode;
		if(index==0){
			preNode = first;
		}else{
			preNode = this.findNode(index-1);
		}
		preNode.next = preNode.next.next;
	}
	
	@Override
	public void set(Object value, int index) {
		// TODO Auto-generated method stub
		if(index<0||index>=this.size()){
			throw new IndexOutOfBoundsException();
		}
		Node node = this.findNode(index);
		node.value = value;
	}
	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		if(index<0||index>=this.size()){
			throw new IndexOutOfBoundsException();
		}
		Node node = this.findNode(index);
		return node.value;
	}
	/**
	 * 查找链表中制定索引的节点，并返回
	 * @param index 节点的索引值，保证索引>0并且索引<链表长度
	 * @return
	 */
	private Node findNode(int index){
		Node currNode = this.first.next; 
		for(int i=0; i<index; i++){
			currNode = currNode.next;
		}
		return currNode;
	}
	private void addNode(Node node,Object value){
		Node newNode = new Node();
		newNode.value = value;
		newNode.next = node.next;
		node.next = newNode;
	}
	
}
