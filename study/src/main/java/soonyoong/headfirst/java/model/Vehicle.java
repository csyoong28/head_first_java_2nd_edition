package soonyoong.headfirst.java.model;

public abstract class Vehicle {
    private String color;
    private String brand;

    

    public Vehicle(String color, String brand) {
        super();
        this.color = color;
        this.brand = brand;
    }

    public Vehicle() {
        super();
    }

    public void move() {
        this.makeNoise();
        System.out.println("vehicle move");
        makeNoise();
    }
    
    protected void makeNoise() {
        System.out.println("vehicle make noise");
    }
}
