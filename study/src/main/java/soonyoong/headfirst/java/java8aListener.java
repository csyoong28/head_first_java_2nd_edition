package soonyoong.headfirst.java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class java8aListener implements ActionListener {
	JButton button;

	public static void main(String[] args) {
		java8aListener gui = new java8aListener();
		gui.go();
	}

	public void go() {
		JFrame frame = new JFrame();
		button = new JButton("click me");
		button.addActionListener(this);
		frame.getContentPane().add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		button.setText("I’ve been clicked!");
	}
}
