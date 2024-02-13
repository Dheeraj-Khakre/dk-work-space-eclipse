package ConstructorReferance;
@FunctionalInterface
interface A{
	Car getCar();
}
class Car{
	void run() {
		System.out.println("car is runing  well");
	}
}

public class Driver {
	public static void main(String[]ages) {
		// TODO Auto-generated method stub

	
	A a = Car::new;
	Car c = a.getCar();
	c.run();
	
	}
}
