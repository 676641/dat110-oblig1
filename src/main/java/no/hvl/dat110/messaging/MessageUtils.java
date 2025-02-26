package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static int MESSAGINGPORT = 8080;
	public static String MESSAGINGHOST = "localhost";

	public static byte[] encapsulate(Message message) {
		
		byte[] data;
		
		data = message.getData();
		byte[] segment = new byte[SEGMENTSIZE];
		
		// Setter lengden i første byte
		segment[0] = (byte) data.length;
		
		// Kopierer payload data
		System.arraycopy(data, 0, segment, 1, data.length);
		
		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {

		byte[] data = new byte[segment[0]]; 
		System.arraycopy(segment, 1, data, 0, segment[0]);
		
		return new Message(data);
		
	}
	
}
