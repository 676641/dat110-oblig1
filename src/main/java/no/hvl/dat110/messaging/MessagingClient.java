package no.hvl.dat110.messaging;


import java.io.IOException;
import java.net.Socket;

import no.hvl.dat110.TODO;

public class MessagingClient {

	// name/IP address of the messaging server
	private String server;

	// server port on which the messaging server is listening
	private int port;
	
	public MessagingClient(String server, int port) {
		this.server = server;
		this.port = port;
	}
	
	// setup of a messaging connection to a messaging server
	public MessageConnection connect () {	

		// client-side socket for underlying TCP connection to messaging server
		Socket clientSocket;

		MessageConnection connection = null;
		
		// TODO - START
		// connect to messaging server using a TCP socket
		// create and return a corresponding messaging connection
		try {
			// Oppretter TCP socket mot server
			clientSocket = new Socket(server, port);
			
			// Oppretter og returnerer en ny messaging connection
			connection = new MessageConnection(clientSocket);
			
		} catch (IOException ex) {
			System.out.println("Messaging client: " + ex.getMessage());
			ex.printStackTrace();
		}
		
		// TODO - END
		return connection;
	}
}
