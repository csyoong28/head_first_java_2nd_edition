package soonyoong.headfirst.java;

import soonyoong.headfirst.java.model.Boat;
import soonyoong.headfirst.java.model.Car;

public class java2bAbstractClass {
	
	public static void main(String[] args) {
		java2bAbstractClass java2bAbstractClass = new java2bAbstractClass();		//abstract class can have constructor, but can't be instantiated by "new"
		java2bAbstractClass.usecase1();
		java2bAbstractClass.usecase2();
	}
	
	public void usecase1() {
	    Car car = new Car("black", "honda"); 
	    car.move();
	}
	
	public void usecase2() {
        Boat boat = new Boat("black", "shipBrand"); 
        boat.move();
    }
}