package FunctionalInterface;
@FunctionalInterface
interface Shape{
	void draw();
}

 /*class Rectangle implements Shape{
	public void draw() {
		System.out.println("rectnagle ");
	}
}
 class Circle implements Shape{
		public void draw() {
			System.out.println("Circle ");
		}
	}
 
 class Triangle implements Shape{
		public void draw() {
			System.out.println("Triangle ");
		}
	}*/
public class LamdaExpressionDemo {

	public static void main(String[] args) {
			
		Shape rect=()->System.out.println("Draw method of rectangle");
		Shape circle=()->System.out.println("Draw method of circle");
		Shape trian=()->System.out.println("Draw method of triangle");
		
		rect.draw();
		circle.draw();
		trian.draw();
		//passing lamda expression as method argument
		lam(rect) ;
		lam(circle);
		lam(trian);
	}
	  
	private static void lam(Shape shape) {
		shape.draw();
	}
	

}
