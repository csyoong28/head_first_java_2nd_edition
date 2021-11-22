package mkyong.java8;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Developer {
	private BigDecimal salary;
	private String name;
	private int age;
	private Set<String> book;
	
	public Developer() {
		super();
	}

	public Developer(String name, BigDecimal salary, int age) {
		super();
		this.salary = salary;
		this.name = name;
		this.age = age;
	}

	public Developer(String name, BigDecimal salary) {
		super();
		this.salary = salary;
		this.name = name;	
	}

	public Developer(String name) {
		this.name = name;
	}
	
	public void addBook(String book) {
		if (this.book == null) {
			this.book = new HashSet<>();
		}
		this.book.add(book);
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Developer [salary=" + salary + ", name=" + name + ", age=" + age + "]";
	}

	public Set<String> getBook() {
		return book;
	}

	public void setBook(Set<String> book) {
		this.book = book;
	}
	

}
