package soonyoong.headfirst.java;

import java.io.*;
import java.net.*;

public class java11aConnectionServer {
	String[] adviceList = { "Take smaller bites", "Go for the tight jeans. No they do NOT make you look fat.",
			"One word: inappropriate", "Just for today, be honest. Tell your boss what you *really* think",
			"You might want to rethink that haircut." };

	public void go() {
		try {
			ServerSocket serverSock = new ServerSocket(4242);

			while (true) {
				Socket sock = serverSock.accept();

				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				String advice = getAdvice();
				writer.println(advice);
				writer.close();
				System.out.println(advice);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	} // close go

	private String getAdvice() {
		int random = (int) (Math.random() * adviceList.length);
		return adviceList[random];
	}

	public static void main(String[] args) {
		java11aConnectionServer server = new java11aConnectionServer();
		server.go();
	}
}
