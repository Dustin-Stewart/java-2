import java.io.InputStream; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.io.OutputStream; 
import java.net.Socket;
import java.util.Scanner;

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
		Integer port = 8083;
        
        // Create some data to send over the socket.
        // Serialized info needs to be the correct type (List<Integer>)
		Integer sleepTime = getSleepTime();

		// 1. Create a socket.
		Socket echoSocket = new Socket(host, port);
		System.out.println("Created socket.");
		
		// 2.  Create the tools to write to the socket.
		OutputStream outputStream = echoSocket.getOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		System.out.println("Created output stream.");
		
		// 4.  Send list to server.
		System.out.println("Sending the sleep time to the server.");
		objectOutputStream.writeObject(sleepTime);
		
		// 3.  Create the tools to read from the socket.
		InputStream serverInputStream = echoSocket.getInputStream();
		ObjectInputStream objectInputStream = new ObjectInputStream(serverInputStream);
		System.out.println("Created input stream.");
		
		System.out.println("Waiting for a response from the server.");
		// 5.  Read the serialized information from the socket,
		//     and cast it to the known type.
		Integer response = (Integer)objectInputStream.readObject();
		
		System.out.println("The server sent...");
		System.out.println(response);

		System.out.println("Closing client.");
	}
}