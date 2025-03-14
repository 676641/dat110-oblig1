package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;
import no.hvl.dat110.TODO;

public class RPCUtils {
	
	public static byte[] encapsulate(byte rpcid, byte[] payload) {
		
		byte[] rpcmsg = new byte[1 + payload.length];
		
		// TODO - START

		rpcmsg[0] = rpcid;
		System.arraycopy(payload, 0, rpcmsg, 1, payload.length);
		
		// TODO - END
		
		return rpcmsg;
	}
	
	public static byte[] decapsulate(byte[] rpcmsg) {
		
		byte[] payload = new byte[rpcmsg.length - 1];
		
		System.arraycopy(rpcmsg, 1, payload, 0, payload.length);
		
		return payload;
		

	}

	// convert String to byte array
	public static byte[] marshallString(String str) {
		
		return str.getBytes();
	}

	// convert byte array to a String
	public static String unmarshallString(byte[] data) {
		
		return new String(data);

	}
	
	public static byte[] marshallVoid() {
		
		return new byte[0];  // Tom array for void

		
	}
	
	public static void unmarshallVoid(byte[] data) {
		
		
	}

	// convert boolean to a byte array representation
	public static byte[] marshallBoolean(boolean b) {
		
		byte[] encoded = new byte[1];
				
		if (b) {
			encoded[0] = 1;
		} else
		{
			encoded[0] = 0;
		}
		
		return encoded;
	}

	// convert byte array to a boolean representation
	public static boolean unmarshallBoolean(byte[] data) {
		
		return (data[0] > 0);
		
	}

	// integer to byte array representation
	public static byte[] marshallInteger(int x) {
		
		return ByteBuffer.allocate(4).putInt(x).array();
	}
	
	// byte array representation to integer
	public static int unmarshallInteger(byte[] data) {
		
		return ByteBuffer.wrap(data).getInt();
		
	}
}
