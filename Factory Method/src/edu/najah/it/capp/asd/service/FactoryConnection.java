package edu.najah.it.capp.asd.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import edu.najah.it.capp.asd.constants.ConnectionType;
import edu.najah.it.capp.asd.impl.Ftp;
import edu.najah.it.capp.asd.impl.Scp;
import edu.najah.it.capp.asd.impl.Ssh;
import edu.najah.it.capp.asd.impl.Telnet;
import edu.najah.it.capp.asd.intf.Protocol;

public class FactoryConnection {
	
	public static Map connections = new HashMap<String, Protocol>();
	//getInstance, createConnection , getConnection 
	//release (String type)
	//getCurrentConnections
	
	public static boolean release(String connectionType) {
		if(connections.containsKey(connectionType)) {
			connections.remove(connectionType);
			if(connectionType.equals(ConnectionType.FTP)) {
				Ftp.getInsatnce().release();
				
			} else if(connectionType.equals(ConnectionType.SSH)) {
				Ssh.getInsatnce().release();
				
			} else if(connectionType.equals(ConnectionType.TELNET)) {
				Telnet.getInsatnce().release();
				 
			} else if(connectionType.equals(ConnectionType.SCP) ) {
				Scp.getInsatnce().release();
				 
			}
			return true;
		}
		
		return false;
		
	}
	public static ArrayList<String> getCurrentConnections() {
		Set<String> keys = connections.keySet();
		
		ArrayList<String> myConnection =  new ArrayList<String>();
		for (String key : keys) {
			myConnection.add(key);
		}
		return myConnection;
		
		
	}

}
    public interface FConnection <T> extends  Connection {
	T create(String type) ;
}

