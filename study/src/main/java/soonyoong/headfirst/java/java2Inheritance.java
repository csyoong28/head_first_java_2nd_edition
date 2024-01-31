package soonyoong.headfirst.java;

public class java2Inheritance {
	public static void main(String[] args) {
		java2Inheritance java2Inheritance = new java2Inheritance();
		java2Inheritance.testPolymorphism2();
	}

	@SuppressWarnings("unused")
	public void testPolymorphism() {
//		Animal animal2 = new Animal();   //Animal is abstract class, cannot be instantiated, compile error
//		Animal animal = new Dog2();
//		animal.bark();	//cannot use mehtod on subclass, can use only those in superclass, compile error
//
//		Dog dog = new Animal();		//even if animal is concrete class, this will have compile error. also cannot cast animal to dog
//		dog.bark();
	}

	public void testPolymorphism2() {
		Animal animal1 = new Dog2();
		Animal animal2 = new Cat();
		animal1.eat();	//bark, thanks and eat make dog sound
		animal2.eat();  //meow, thanks and eat make cat sound

		Animal animal3 = (Animal)new Dog2();
		animal3.eat();	//bark, thanks and eat make dog sound

		System.out.println(animal3.sound);  //animal sound

	}
}
