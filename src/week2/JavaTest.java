package week2;

import java.net.ServerSocket;
import java.net.Socket;

public class JavaTest {

	public static void main(String[] args) {
		System.out.println("arguments size is " + args.length);
		for(int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		
		Socket socket;
		ServerSocket sSocket;
	}
}
