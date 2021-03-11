import java.io.InputStream; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.io.OutputStream; 
import java.net.Socket;
import java.util.Scanner;

/**
 * A simple client for use with an echo server. 
 */ 
public class EchoClient {

    /**
	 * Prompts the user for an integer
	 */
	public static Integer getSleepTime() {
		Integer time;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter time thread should sleep: ");
		time = (Integer) input.nextInt();
		
		return time;
	}

	public static void main(String[] args) throws Exception {
		String host = "localhost";
		Integer port = 8085;
        
        // Create some data to send over the socket.
		int sleepTime = getSleepTime();

		// Create a socket.
		Socket echoSocket = new Socket(host, port);
		System.out.println("Created socket.");
		
		// Create the tools to write to the socket.
		OutputStream outputStream = echoSocket.getOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		System.out.println("Created output stream.");
		
		// Send request to the server.
		System.out.println("Sending the sleep time to the server.");
		objectOutputStream.writeObject(sleepTime);
		
		// Create the tools to read from the socket.
		InputStream serverInputStream = echoSocket.getInputStream();
		ObjectInputStream objectInputStream = new ObjectInputStream(serverInputStream);
		System.out.println("Created input stream.");
		
		System.out.println("Waiting for a response from the server.");
		// Read serialized information and cast it to the known type.
		Integer response = (Integer)objectInputStream.readObject();
		
		System.out.println("The server sent...");
		System.out.println(response);

		System.out.println("Closing client.");
	}
}