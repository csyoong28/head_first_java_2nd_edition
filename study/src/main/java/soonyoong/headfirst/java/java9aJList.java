package soonyoong.headfirst.java;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class java9aJList implements ListSelectionListener {
	JList list;

	public static void main(String[] args) {
		java9aJList gui = new java9aJList();
		gui.go();
	}

	public void go() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button = new JButton("Just Click It");
		String[] listEntries = { "11111", "2222", "333", "44444", "55555" };
		list = new JList(listEntries);

		JScrollPane scroller = new JScrollPane(list);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		panel.add(scroller);

		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.getContentPane().add(BorderLayout.SOUTH, button);

		frame.setSize(350, 300);
		frame.setVisible(true);
	}

	public void valueChanged(ListSelectionEvent lse) {
		if (!lse.getValueIsAdjusting()) {
			String selection = (String) list.getSelectedValue();
			System.out.println(selection);
		}
	}

	/*public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}*/

}
