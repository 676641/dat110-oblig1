package no.hvl.dat110.rpc;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.*;

public class RPCClient {

	// underlying messaging client used for RPC communication
	private MessagingClient msgclient;

	// underlying messaging connection used for RPC communication
	private MessageConnection connection;
	
	public RPCClient(String server, int port) {
	
		msgclient = new MessagingClient(server,port);
	}
	
	public void connect() {
		
		connection = msgclient.connect();

		// TODO - END
	}
	
	public void disconnect() {
		
		connection.close();
	}


	/*
	 Make a remote call om the method on the RPC server by sending an RPC request message and receive an RPC reply message

	 rpcid is the identifier on the server side of the method to be called
	 param is the marshalled parameter of the method to be called
	 */

	public byte[] call(byte rpcid, byte[] param) {
		
		byte[] returnval = null;
		
		// Lag RPC request
		byte[] request = RPCUtils.encapsulate(rpcid, param);
		
		// Lag Message og send
		Message requestMsg = new Message(request);
		connection.send(requestMsg);
		
		// Motta svar
		Message responseMsg = connection.receive();
		
		// Pakk ut svaret
		byte[] response = responseMsg.getData();
		returnval = RPCUtils.decapsulate(response);
		
		return returnval;
		
	}

}
