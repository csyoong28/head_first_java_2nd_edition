package soonyoong.headfirst.java;

public class java7Exception {
	public void takeRisk() throws NullPointerException { // tell the world that it throws a BadException
		if (true) {
			throw new NullPointerException(); // create new Exception object and throw it
		}
	}
}
