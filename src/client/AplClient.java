package client;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Client side of the application. Main thread of the application handles the
 * output to the server while a sub-thread handles incoming messages
 *
 * Jaspervl
 */
public class AplClient {

	// Declaring / initializing instance variables
	private static final String SERVER_ADDRESS = "localhost"; //Standard host
	private static final int SERVER_PORT = 7777;   // Accessible port
	private static Socket socket;
	private static Scanner in;

	/**
	 * 
	 * @param args	Optional system arguments
	 * @throws UnknownHostException If it cant find the host
	 * @throws IOException	When an invalid input/output operation has been performed
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		socket = new Socket(SERVER_ADDRESS, SERVER_PORT); // Create new socket
		
		PrintWriter writer = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()));
		UserListener listener = new UserListener(socket.getInputStream());
		listener.start();
		in = new Scanner(System.in);
		/*
		 * Iterating
		 */
		while (true) {
			if (in.hasNextLine()) {
				writer.println((in.nextLine()));
				writer.flush();
			}
		}
	}

	
	/**
	 * Making sure the socket and any other resources gets closed when the GC 
	 */
	@Override
	protected void finalize() throws Throwable {
		socket.close();
		in.close();
		super.finalize();
	}
}
