import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//sending client
public class SampleSendingServer {
	public static void main(String[] args) { 
		 try { 
			 int port = 8000; 
			 System.out.printf( "server @ %d...\n", port ); 
			 
			 ServerSocket server = new ServerSocket( port ); 
			 Socket socket = server.accept(); 
			 
			 System.out.printf( "client @ %d\n", socket.getPort() ); 
			 
			 OutputStream outStream = socket.getOutputStream(); 
			 PrintWriter out = new PrintWriter( outStream, true ); 
			 out.println( "Thanks for visiting. Bye!" ); 
			 socket.close(); 
			 server.close(); 
		 } 
		 
		 catch (IOException e) { 
			 e.printStackTrace(); 
		 } 
		 
		 System.out.println( "closing..." ); 
	} 
} 

