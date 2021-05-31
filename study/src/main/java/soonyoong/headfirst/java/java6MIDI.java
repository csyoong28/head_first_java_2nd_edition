package soonyoong.headfirst.java;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

public class java6MIDI {
	public void play() {
		try {
			Sequencer sequencer = MidiSystem.getSequencer();
			System.out.println("We got a sequencer");
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		java6MIDI mt = new java6MIDI();
		mt.play();
	}
}
