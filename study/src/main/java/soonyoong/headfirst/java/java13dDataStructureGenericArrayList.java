package soonyoong.headfirst.java;

import java.util.*;
import java.io.*;

public class java13dDataStructureGenericArrayList {
	ArrayList<Song> songList = new ArrayList<Song>();

	public static void main(String[] args) {
		new java13dDataStructureGenericArrayList().go();
	}
	
	
	public void go() {
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(new Dog());
		animals.add(new Cat());
		animals.add(new Dog());
		takeAnimals(animals);

		ArrayList<Dog> dogs = new ArrayList<Dog>();
		dogs.add(new Dog());
		dogs.add(new Dog());
		takeAnimals(dogs);
		injectAnimals(dogs);
	}

	public void takeAnimals(ArrayList<Animal> animals) {
		for (Animal a : animals) {
			a.eat();
		}
	}
	
	public void injectAnimals(ArrayList<? extends Animal> animals) {
		animals.add(new Dog());			//having the ? wildcard, will not allow to add to the collection
	}
	
	public <T extends Animal>void injectAnimals2(ArrayList<T> animals) {
		animals.add(new Dog());			//this declaration is same with ? wildcard version
	}
}
