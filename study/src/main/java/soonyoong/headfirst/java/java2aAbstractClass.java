package soonyoong.headfirst.java;

public class java2aAbstractClass {
	private String serialNumber;
	private double price;
	private InstrumentSpec spec;

	public java2aAbstractClass(String serialNumber, double price,
	                    InstrumentSpec spec) {
	    this.serialNumber = serialNumber;
	    this.price = price;
	    this.spec = spec;
	  }

// Get and set methods for serial number and price
	public InstrumentSpec getSpec() {
		return spec;
	}
	
	public static void main(String[] args) {
	//	java2aAbstractClass aa = new java2aAbstractClass();		//abstract class can have constructor, but can't be instantiated by "new"
		
	}
}