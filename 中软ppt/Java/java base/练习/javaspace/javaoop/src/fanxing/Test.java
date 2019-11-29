package fanxing;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Object> list = new ArrayList<Object>();
		D d = new D();
		d.printAll(list);
		
		I<A> i1 = new ImpA<A>();
		I<C> i2 = new ImpA<C>();
		I<B> i3 = new ImpB();

	}
}
interface I<T extends A>{
	T getValue();
}
class ImpA<T extends A> implements I<T>{
	T value;
	public T getValue(){
		return this.value;
	}
}
class ImpB implements I<B>{
	B value;
	public B getValue(){
		return this.value;
	}
}
class A{
	
}
class B extends A{
	
}
class C extends B{
	
}


class D{
	public <T> void printAll(List<? super B> list){
		for(int i=0; i<list.size(); i++){
			T value = (T)list.get(i);
			System.out.println(value);
		}
	}
}

