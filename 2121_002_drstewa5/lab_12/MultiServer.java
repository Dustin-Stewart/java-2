import java.io.IOException;
import java.io.InputStream; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.io.OutputStream; 
import java.net.ServerSocket; 
import java.net.Socket; 
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * A multithreaded version of our simple echo server from Lab 11. 
 * @author Franklin D. Worrell
 * @version 23 April 2018 
 */ 
public class MultiServer {

	private int port;
	private ServerSocket socket;

	public MultiServer(int port) throws Exception{
		this.port = port;
		this.socket = new ServerSocket(this.port);
	}

	private Runnable getRunnableRequest(Socket Client){
		return new ClientRequest(Client);
	}
	public static void main(String[] args) throws Exception{
		//create server instance where we accept requests over network
		MultiServer server = new MultiServer(8085);

		//create a thread pool
		ExecutorService pool = Executors.newCachedThreadPool(); //exectuters are things that run stuff, a thread pool is a group of unused threads

		//listen for incoming connections
		while (true) {
			Socket client = server.socket.accept();
			pool.execute(server.getRunnableRequest(client));
		}
	}

	private class ClientRequest implements Runnable{

		private Socket client; 

		public ClientRequest(Socket client){
			this.client = client;

			@Override
			public void run(){
				try{
			// Receive the integer from the connected client. 
			System.out.println("Received connection. Receiving request."); 
			InputStream input = this.client.getInputStream(); 
			ObjectInputStream objectInput = new ObjectInputStream(input); 
			int sleepTime = (Integer) objectInput.readObject(); 
			
			// Sleep for the specified time. 
			System.out.println("Received " + sleepTime + " from client."); 
			System.out.println("Sleeping for " + sleepTime + " seconds."); 
			Thread.sleep(sleepTime * 1000); 
			
			// Echo back the integer to the client. 
			System.out.println("Echoing back to client."); 
			OutputStream output = this.client.getOutputStream(); 
			ObjectOutputStream objectOutput = new ObjectOutputStream(output); 
			objectOutput.writeObject(sleepTime); 
			
			// Clean up and close streams and client socket. 
			System.out.println("Cleaning up after serving request.");
			objectOutput.flush(); 
			objectOutput.close(); 
			objectInput.close(); 
			this.client.close(); 
			} catch()
		}
	}
}