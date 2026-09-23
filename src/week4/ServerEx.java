package week4;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Scanner;

public class ServerEx {
	public static void main(String[] args) {
		BufferedWriter out = null;
		Scanner scanner = new Scanner(System.in, Charset.forName("MS949"));
		ServerSocket listener = null;
		Socket socket = null;
		try {
			listener = new ServerSocket(9999);
			System.out.println("연결을 기다리고 있습니다.....");
			socket = listener.accept();
			System.out.println("클라이언트와 연결되었습니다.");
			
			ServerReciever cr = new ServerReciever(socket);
			cr.start();
			
			out = new BufferedWriter(
                new OutputStreamWriter(
                    socket.getOutputStream(),
                    Charset.forName("MS949")
                )
            );
			while (true) {
				String outputMessage = scanner.nextLine();
                out.write(outputMessage);
                out.newLine();
                out.flush();
                if (outputMessage.equalsIgnoreCase("bye")) {
                    break;
                }
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				scanner.close();
				socket.close();
				listener.close();
			} catch (IOException e) {
				System.out.println("클라이언트와 채팅 중 오류가 발생했습니다.");
			}
		}
	}
}