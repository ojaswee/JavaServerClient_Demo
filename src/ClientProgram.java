//First run ServerProgram then run ClientProgrm

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientProgram {
	public static void main (String args[]) throws UnknownHostException, IOException {
		
		int num, value; 
		//to accept anything from user we need Scanner object
		Scanner sc = new Scanner(System.in);
		
		//Socket is an object which enables client and user to communicate
		//first parameter is IP address of the machine in our case local host so 127.0.0.1
		//second parameter is port number
		Socket s = new Socket("127.0.0.1",1342);
		
		Scanner sc1 = new Scanner(s.getInputStream()); 
		
		System.out.println("Enter a number");
		num = sc.nextInt();
		
		//formats the primitive values (int/long) to text - like 
		PrintStream p= new PrintStream(s.getOutputStream());
		
		//pass number to client
		p.println(num);
		
		//accept result from server
		value= sc1.nextInt();
		System.out.printf("Double of %d is %d\n", num,value);
	}
}
