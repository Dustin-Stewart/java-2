import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
@author Dustin Stewart
@versin 19 April 2017

A basic echo server that receives an <code>Interger</code> from a client, sleeps for the 
number of seconds specified by that Integer, wakes up, and finally echoes the Integer back
to the client.
*/

public class EchoServer {
	public static void main(String[] args) throws Exception{ //throws all exceptions by main. dont do this
		//Create a server socket
		String host = "localhost";
		int port = 8083;
		ServerSocket server =  new ServerSocket(port);

		//wait for a client to connect (busy wait loop)
		while (true) {
			System.out.println("Awaiting incoming connection...");
			//Accept incoming connections when they happen
			Socket client = server.accept(); //references to a client aree of type socket

			//receive the integer from the connected client
			System.out.println("Received connection. Receiving request...");
			InputStream input = client.getInputStream();
			ObjectInputStream objectInput = new ObjectInputStream(input);
			int sleepTime = (Integer) objectInput.readObject();

			//sleep for a specified time
			System.out.println("Received " + sleepTime + " from client.");
			System.out.println("Sleeping for " + sleepTime + " seconds...");
			Thread.sleep(sleepTime * 1000); //*1000 to convert second into miliseconds

			//echo back the integer to the client
			System.out.println("Echoing back to Client...");
			OutputStream output = client.getOutputStream();
			ObjectOutputStream objectOutput = new ObjectOutputStream(output);
			objectOutput.writeObject(sleepTime);
			
			//clean up and close streams and client socket
			System.out.println("Cleaning up after serving request...");
			objectOutput.flush();
			objectOutput.close();
			objectInput.close();
			client.close();
		}
	}
}