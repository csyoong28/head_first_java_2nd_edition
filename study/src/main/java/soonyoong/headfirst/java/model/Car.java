package soonyoong.headfirst.java.model;

public class Car extends Vehicle {

    public Car(String color, String brand) {
        super(color, brand);
    }

    @Override
    protected void makeNoise() {
        System.out.println("car beep beep");
    }

}