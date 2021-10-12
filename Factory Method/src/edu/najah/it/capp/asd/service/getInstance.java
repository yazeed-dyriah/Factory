package edu.najah.it.capp.asd.service;
import edu.najah.it.capp.asd.service.Connection;
import edu.najah.it.capp.asd.service.FactoryConnection;


import edu.najah.it.capp.asd.constants.ConnectionType;
import edu.najah.it.capp.asd.impl.Ftp;
import edu.najah.it.capp.asd.impl.Scp;
import edu.najah.it.capp.asd.impl.Ssh;
import edu.najah.it.capp.asd.impl.Telnet;
import edu.najah.it.capp.asd.intf.Protocol;

public class getInstance {
    public class GetInstances implements  FactoryConnection {

	public static Protocol getInstance(String connectionType) {
		if(Connections.containsKey(connectionType)) {
			
			System.out.println("Connection is already created!.");
			return (Protocol) connections.get(connectionType);
		} else {
			if(connections.size() >= 3 ) {
				//do not create connection
				System.out.println("Can't create more than 3 connection!!");
				return null;
			}
			if(connectionType.equals(ConnectionType.FTP)) {
				Protocol ftp = new Ftp();
				connections.put(connectionType, ftp);
				return ftp;//Create a new instance
			}
			if(connectionType.equals(ConnectionType.SSH)) {
				connections.put(connectionType, Ssh.getInsatnce());
				return Ssh.getInsatnce();
			}
			if(connectionType.equals(ConnectionType.TELNET)) {
				connections.put(connectionType, Telnet.getInsatnce());
				return Telnet.getInsatnce();
			}
			if(connectionType.equals(ConnectionType.SCP)) {
				connections.put(connectionType, Scp.getInsatnce());
				return Scp.getInsatnce();
			}
		}
		return null;

	}



}

}
