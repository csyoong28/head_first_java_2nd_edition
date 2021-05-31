package soonyoong.headfirst.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class java8cTestFor8b implements ActionListener {
    JFrame frame;
    public static void main (String[] args) {
       java8cTestFor8b gui = new java8cTestFor8b();
       gui.go();
    }
    public void go() {
       frame = new JFrame();
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       JButton button = new JButton("Change colors");
       button.addActionListener(this);
       
       java8bMyDrawPanel drawPanel = new java8bMyDrawPanel();
       
       frame.getContentPane().add(BorderLayout.SOUTH, button);
       frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
       frame.setSize(300,300);
       frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent event) {
        frame.repaint();
    }
}
