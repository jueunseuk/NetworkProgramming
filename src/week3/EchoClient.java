package week3;

import java.io.*;
import java.net.*;
import java.util.*;
import java.nio.charset.Charset;

public class EchoClient {
    public static void main(String[] args) {
    		BufferedReader in = null;
        BufferedWriter out = null;
        Socket socket = null;
        Charset socketCharset = Charset.forName("UTF-8");
        Scanner scanner = new Scanner(System.in, Charset.forName("MS949"));
        try {
            socket = new Socket("localhost", 9999);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(
                new OutputStreamWriter(
                    socket.getOutputStream(),
                    socketCharset
                )
            );
            while (true) {
                System.out.print("텍스트 입력 >> ");
                String outputMessage = scanner.nextLine();
                out.write(outputMessage);
                out.newLine();
                out.flush();
                String inputMessage = in.readLine();
                if (outputMessage.equalsIgnoreCase("bye") || outputMessage.equals("끝")) {
                    break;
                }
                System.out.println("Echo from Server -> "+inputMessage);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
	            	scanner.close();
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                System.out.println("서버와 채팅 중 오류가 발생했습니다.");
            }
        }
    }
}