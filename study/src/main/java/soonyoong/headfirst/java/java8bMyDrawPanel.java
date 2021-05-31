package soonyoong.headfirst.java;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class java8bMyDrawPanel extends JPanel {
	public void paintComponent(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect(20, 50, 300, 100);

		g.fillRect(0, 0, this.getWidth(), this.getHeight()); // fill background
		int red = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		Color randomColor = new Color(red, green, blue);
		g.setColor(randomColor);
		g.fillOval(70, 70, 100, 100);
		// paint gradient
		GradientPaint gradient = new GradientPaint(70, 70, Color.blue, 150, 150, Color.green);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(gradient);
		g2d.fillOval(90, 90, 100, 100);
		// absolute path
		// Image image = new ImageIcon("C:\\Users\\soonyoong.chia\\github\\java\\head_first_java_2nd_edition\\study\\src\\main\\resources\\catzilla.jpg").getImage();

		// resource
		URL res = getClass().getClassLoader().getResource("catzilla.jpg");
		Image image = new ImageIcon(res).getImage();
		// try and error
		// Image image = new ImageIcon("src/main/resources/catzilla.jpg").getImage();
		g.drawImage(image, 200, 200, this);
	}
}
