package soonyoong.headfirst.java;

import java.io.*;

public class java10Serializable implements Serializable {

	private int width;
	private int height;
	transient String currentID;

	public void setWidth(int w) {
		width = w;
	}

	public void setHeight(int h) {
		height = h;
	}

	public static void main(String[] args) {
		java10Serializable myBox = new java10Serializable();
		myBox.setWidth(50);
		myBox.setHeight(20);
		try {
			FileOutputStream fs = new FileOutputStream("java10Serializable.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(myBox);
			os.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
