package mkyong.java8;

import java.util.Optional;

public class Person2 {
    private String name;
    private int age;
    private String password;

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }
    
//    public String getName() {
//        return name;
//       // return Optional.ofNullable(name);
//    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public Optional<Integer> getAge() {
        return Optional.ofNullable(age);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Optional<String> getPassword() {
        return Optional.ofNullable(password);
    }

    public Person2(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

}