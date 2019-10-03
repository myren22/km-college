import java.io.IOException;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//Receiving client
public class GuessingServer {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(5150);
			
			boolean exit = false;
			while(exit == false){
				Socket client = server.accept();
				Scanner     in = new Scanner    ( client.getInputStream() );
				PrintWriter out  = new PrintWriter( client.getOutputStream(), true );
				
				int guess=0;
				int upperbound=0;
				int lowerbound=0;
				int increment = 0;
				while(in.hasNext())
				{
					String line = in.nextLine();
					Scanner     scanLine = new Scanner    (line);
					if((line.equals("SHUT DOWN")) && increment == 0){
						exit = true;
						break;
					}	
					
					
					if(increment == 0){
						lowerbound = scanLine.nextInt();
						upperbound = scanLine.nextInt();
						int difference = upperbound - lowerbound;
						guess = lowerbound + difference / 2;
						out.println(guess);
					}		
					if((line.equals("won") || (line.equals("lost"))))
					{
						break;
					}
					if(line.equals("low")){
						lowerbound = guess;
						int difference = upperbound - lowerbound;
						guess = lowerbound + difference / 2;
						out.println(guess);
					}
					if(line.equals("high")){
						upperbound = guess;
						int difference = upperbound - lowerbound;
						guess = lowerbound + difference / 2;
						out.println(guess);
					}
					scanLine.close();
					increment++;				
				}
				in.close();
				out.close();
				client.close();
			}
			
			server.close();
			
			

			
		}

		catch (IOException e) {
			
		}
		// System.out.println( "closing..." );
	}
}

/*
 * setup stream
 * check shutdown 
 * 		set bounds 
 * 		guess 
 * 		take 1 of 4 answers 
 * 		when win or losing, move to next client 
 * 		if next client first input is SHUT DOWN, close
 * server
 */