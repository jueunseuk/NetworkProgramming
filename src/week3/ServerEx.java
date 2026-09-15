package week3;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;

public class ServerEx {
	public static void main(String[] args) {
		BufferedReader in = null;
		ServerSocket listener = null;
		Socket socket = null;
		Charset charset = Charset.forName("UTF-8");
		try {
			listener = new ServerSocket(9999); // 서버 소켓 생성
			System.out.println("연결을 기다리고 있습니다.....");
			socket = listener.accept(); // 클라이언트로부터 연결 요청 대기
			System.out.println("연결되었습니다.");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream(), charset)); // 소켓 입력 스트림
			while (true) {
				String inputMessage = in.readLine(); // 클라이언트로부터 한 행 읽기
				if (inputMessage.equalsIgnoreCase("bye") || inputMessage.equals("끝")) {
					System.out.println("클라이언트에서 bye로 연결을 종료하였음"); // 받은 메시지를 화면에 출력
					break;  // "bye"를 받으면  연결 종료
				}
				System.out.println("... " + inputMessage); // 받은 메시지를 화면에 출력			
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close(); // 통신용 소켓 닫기
				listener.close(); // 서버 소켓 닫기
			} catch (IOException e) {
				System.out.println("클라이언트와 채팅 중 오류가 발생했습니다.");
			}
		}
	}
}