package soonyoong.headfirst.java;

public class java2Inheritance {
	public static void main(String[] args) {
		java2Inheritance java2Inheritance = new java2Inheritance();
		
	}
	
	public void testPolymorphism() {
		Animal animal2 = new Animal();   //Animal is abstract class, cannot be instantiated
		Animal animal = new Dog();
		animal.bark();	//cannot use mehtod on subclass, can use only those in superclass
	}
}
