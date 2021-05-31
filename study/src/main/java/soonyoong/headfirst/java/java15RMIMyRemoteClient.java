package soonyoong.headfirst.java;

import java.rmi.*;
import java.rmi.server.*;

public class java15RMIMyRemoteClient {

	public void go() {
		try {
			java15RMIMyRemote service = (java15RMIMyRemote) Naming.lookup("rmi://127.0.0.1/Remote Hello");
			String s = service.sayHello();
			System.out.println(s);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new java15RMIMyRemoteClient().go();
	}
}
