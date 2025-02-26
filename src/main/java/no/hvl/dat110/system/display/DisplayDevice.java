package no.hvl.dat110.system.display;

import no.hvl.dat110.rpc.RPCServer;
import no.hvl.dat110.system.controller.Common;


public class DisplayDevice {
	
	public static void main(String[] args) {
		
		System.out.println("Display server starting ...");
		
		// TODO - START
		RPCServer displayServer = new RPCServer(Common.DISPLAYPORT);
		new DisplayImpl((byte) 1, displayServer);
		
		displayServer.run();
	
		displayServer.stop();
		
		// TODO - END
		
		System.out.println("Display server stopping ...");
		
	}
}
