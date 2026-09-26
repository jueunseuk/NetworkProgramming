package week4;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Scanner;

public class ClientEx {
    public static void main(String[] args) {
        BufferedWriter out = null;
        Socket socket = null;
        Scanner scanner = new Scanner(System.in, Charset.forName("MS949"));
        try {
            socket = new Socket("localhost", 9999);
            
            ClientReciever cr = new ClientReciever(socket);
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
            scanner.close();
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                System.out.println("서버와 채팅 중 오류가 발생했습니다.");
            }
        }
        
        System.out.println("ClientEx 종료");
    }
}
