package FunctionalInterface;

@FunctionalInterface
interface First{
	void m1();
	//static methods we can have
	static void m2() {
		System.out.println("static method interface");
	}
	//we can also have default methods
	default void m3() {
		System.out.println("default method interface");
	}
	
}
class Second implements First{
	public void m1() {
		 System.out.println("abstract method implementation");
	 }
}
 class FunctionalInterfaceDemo {
	public static void main(String[] args) {
		First f=new Second();
		f.m1();
		f.m3();
		First.m2();
	}

}
