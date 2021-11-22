package soonyoong.headfirst.java.model;

public class Boat extends Vehicle {

    public Boat(String color, String brand) {
        super(color, brand);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void makeNoise() {
        System.out.println("boat roar");
    }

}
