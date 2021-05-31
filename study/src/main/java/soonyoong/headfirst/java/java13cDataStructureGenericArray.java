package soonyoong.headfirst.java;

import java.util.*;
import java.io.*;

public class java13cDataStructureGenericArray {
	ArrayList<Song> songList = new ArrayList<Song>();

	public static void main(String[] args) {
		new java13cDataStructureGenericArray().go();
	}

	public void go() {
		Animal[] animals = { new Dog(), new Cat(), new Dog() };
		Dog[] dogs = { new Dog(), new Dog(), new Dog() };
		takeAnimals(animals);
		takeAnimals(dogs);
	}

	/*public void takeAnimals(Animal[] animals) {
		for (Animal a : animals) {
			a.eat();
		}
	}*/
	
	public void takeAnimals(Animal[] animals) {		//pass compile, but fail at runtime
		   animals[0] = new Cat();
	}
	
	public void create() {		//pass compile, but fail at runtime
		   ArrayList<Dog> dogs1 = new ArrayList<Animal>();
		   ArrayList<Dog> dogs2 = new ArrayList<Dog>();
	}
}
