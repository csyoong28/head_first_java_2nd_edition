package soonyoong.headfirst.java;

import java.rmi.*;

public interface java15RMIMyRemote extends Remote{
	public String sayHello() throws RemoteException;
}
