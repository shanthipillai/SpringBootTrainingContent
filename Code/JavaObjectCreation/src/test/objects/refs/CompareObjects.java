package test.objects.refs;

public class CompareObjects {
public static void main(String[] args) {
	CompareObjects obj1=new CompareObjects();
	CompareObjects obj2=new CompareObjects();
	System.out.println(obj1.hashCode());
	System.out.println(obj2.hashCode());
	
	CompareObjects obj3=obj1;
	System.out.println(obj3.hashCode());
	
	
	System.out.println(obj1==obj2);
	System.out.println(obj1==obj3);
}
}
