package client;

import java.util.HashMap;

/**
 * Utility class containing the necessary status codes of the server. Belonging to the first week of webtechnologie internet-technologie chat client
 * 
 * @author jasper
 *
 */
public class ProtocolUtility {
	/*
	 * Map containing all the status codes
	 */
	private static final HashMap<Integer,String> statusCode = new HashMap<>();
	
	/*
	 * Add default statuscodes
	 */
	static{
		statusCode.put(1,"Welcome,please insert your nickname");
		statusCode.put(2, "For all chat commands,please type !HELP");
		statusCode.put(3, "Recipient doesn't exists");
		statusCode.put(4, "False syntax");
		statusCode.put(5, "Nickname has already been registered");
		statusCode.put(6, "Nickname value left out");
		statusCode.put(7, "Options : \n1:Type /w <username> to select your conversation partner \n2:Change nickname by !CHANGENICK <new nick> \n3:Type !SHOWUSERS to see all the current sessions\n4:Type !BROADCAST to send a message to all online users");
		statusCode.put(8, "Invalid value : correct format !BROADCAST <VALUE>");
	}
	
	/**
	 * Checks if the protocol contains the status code
	 * @param code The code to check
	 * @return Corresponding message
	 */
	public static String getMessage(int code){
		String arg = statusCode.get(code);
		return arg == null? "Undefined":arg;
	}
}
