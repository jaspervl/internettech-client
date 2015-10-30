package client;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 
 * Listen for incoming messages from the server and print them.
 * Also,interprets statuscodes
 * 
 * Jaspervl
 */
public class UserListener extends Thread {

	InputStream input;

	/**
	 * Constructor sets the inputstream to listen to
	 * @param input the clients input streamS
	 */
	public UserListener(InputStream input) {
		this.input = input;
	}

	/**
	 * Handle input
	 */
	public void run() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new BufferedInputStream(input)));
		while (true) {
			try {
				String message;
				if ((message = reader.readLine()) != null) {
					try {
						int i = Integer.parseInt(message);
						System.out.println(ProtocolUtility.getMessage(i));
					} catch (Exception e) {
						System.out.println(message);
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}