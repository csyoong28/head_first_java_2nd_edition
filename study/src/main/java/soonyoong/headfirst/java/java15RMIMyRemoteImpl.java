package soonyoong.headfirst.java;

import java.rmi.*;
import java.rmi.server.*;

public class java15RMIMyRemoteImpl extends UnicastRemoteObject implements java15RMIMyRemote {

	public String sayHello() {
		return "Server says, ‘Hey’";
	}

	public java15RMIMyRemoteImpl() throws RemoteException {
	}

	public static void main(String[] args) {
		try {
			java15RMIMyRemote service = new java15RMIMyRemoteImpl();
			Naming.rebind("Remote Hello", service);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
