package soonyoong.headfirst.java;

import java.io.FileNotFoundException;

import javax.sound.midi.MidiUnavailableException;

public class java7Exception {
	public void takeRisk() /*throws NullPointerException */{ // tell the world that it throws a BadException
		if (true) {
			throw new NullPointerException(); // create new Exception object and throw it
			throw new ClassNotFoundException();
		}
	}
}
