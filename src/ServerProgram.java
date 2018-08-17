import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerProgram {
	public static void main (String args[]) throws IOException {
		int num, value; 
		
		//Server socket to specify the port number
		ServerSocket s1 = new ServerSocket(1342);
		
		System.out.println("Server running, waiting on client");
		//accept the incoming request into s1
		Socket ss = s1.accept();
		
		//accept the number
		Scanner sc = new Scanner(ss.getInputStream());
		
		num = sc.nextInt();
		System.out.printf("User input: %d\t", num);
		
		//modification to the accepted num
		value = num*2; 
		
		System.out.printf("returned double %d\n", value);
		//pass the result to client
		PrintStream p = new PrintStream(ss.getOutputStream());
		p.println(value);
	}
}
