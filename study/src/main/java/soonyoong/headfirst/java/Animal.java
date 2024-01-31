package soonyoong.headfirst.java;

public abstract class Animal {
	int age;
	int weight;

	String sound = "animal sound";
	
	public void eat() {
		System.out.println("eat Sth make " +  sound);
	}
}
