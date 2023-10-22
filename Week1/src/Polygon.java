import java.util.Scanner;
// Tính trừu tượng
abstract class Polygon {
	abstract void calculateArea();
}
// Tính kế thừa
// Tính đóng gói
class Triangle extends Polygon {
	private double base;
	private double height;
	
	public void set(double base, double height) {
		this.base = base;
		this.height = height;
	}
	
	void calculateArea() {
		double area = this.base * this.height / 2;
		System.out.println(area);
	}
}
// Tính đa hình
class Rectangle {
  void calculatePerimeter(double length, double width) {
    double area = (length + width) * 2;
    System.out.println(area);
  }
  void calculatePerimeter(double side) {
    double area = side * 4;
    System.out.println(area);
  }
}

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double base = input.nextDouble();
    double height = input.nextDouble();
    double length = input.nextDouble();
    double width = input.nextDouble();
    double side = input.nextDouble();
    
    Triangle obj1 = new Triangle();
    obj1.set(base, height);
    obj1.calculateArea();
    
    Rectangle obj2 = new Rectangle();
    obj2.calculatePerimeter(length, width);
    obj2.calculatePerimeter(side);
    input.close();
  }
}