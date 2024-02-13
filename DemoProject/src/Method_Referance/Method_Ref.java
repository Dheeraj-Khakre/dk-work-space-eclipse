package Method_Referance;

import java.util.ArrayList;


@FunctionalInterface
interface A {
	void m2();
}

public class Method_Ref {
	public int  run() {
		System.out.println("verything is runing - well");
		return 10;
	}

	public static void main(String[] args) {
	ArrayList<Integer> list = new ArrayList<Integer>();
	 
//
//		Method_Ref m1 = new Method_Ref();
//		A a = m1::run;
//		a.m2();
	
	    list.add(12);
	    list.add(54);
	    list.add(78);
	    list.add(85);
	    list.add(null);
	    list.forEach(i->System.out.println(i));
	    list.add(7);
	    list.add(89);
	    list.forEach(System.out::println);
	}
}
