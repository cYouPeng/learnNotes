package wrapper;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a = 10;
//		a = a + 1;
////		Integer obj = new Integer(10);
////		obj = new Integero(bj.intValue()+1);
//		Integer num = 10;//省略了创建对象的代码，自动装箱
//		num = num+1;//省掉了对象.xxxValue()的过程，自动拆箱
////		把值封装进对象：装箱
////		把值从对象中取出：拆箱
////		Double num2 = 10;//错误因为，double值可以自动装箱成Double，但是int只能装箱成Integer
////		String s = 10;
//		String s = 10+"";
//		Double num2 = (double)10;
//		double num3 = 10;
//		
//		int b = Integer.parseInt("123");
//		
//		System.out.println(a);
//		System.out.println(b);
//		//System.out.println(obj);
//		
//		for(int i=Integer.MIN_VALUE; i<=Integer.MAX_VALUE; i++){
//			System.out.println(i);
//		}
//		
//		Character ch1 = 'a';
//		ch1 = (char)(ch1+1);
//		//ch1 += 1;
		for(int i=0; i<10; i++){
			String s = "abc";
		}
		
//		String s1 = "abc";
//		String s2 = "abc";
		
		
//		String s3 = new String("abc");
//		String s4 = new String("abc");
//		System.out.println("s3==s4:"+(s3==s4));
		Integer i3 = new Integer(1000);
		Integer i4 = new Integer(1000);
		//i1，i2的值在byte的范围内是保存在常量池中，超出范围，就在堆区
		Integer i1 = 128;
		Integer i2 = 128;
		System.out.println("i1="+i1+",i2="+i2+",i3="+i3+",i4="+i4);
		System.out.println("i1==i2:"+(i1==i2));
		System.out.println("i3==i4:"+(i3==i4));
		System.out.println("i3.equals(i4):"+i3.equals(i4));
		System.out.println("i3.equals(i4):"+(i3.intValue()==i4.intValue()));
		
		
		Integer i = null;
		i=10+10;
	}

}
