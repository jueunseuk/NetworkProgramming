package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.Charset;

class ClientReciever extends Thread {

    private final Socket socket;

    public ClientReciever(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), Charset.forName("MS949")));

            while (true) {
                String inputStr = br.readLine();

                if (inputStr == null) {
                    break;
                }

                if (inputStr.equalsIgnoreCase("bye")) {
                    System.out.println("서버에서 연결을 해제");
                    break;
                }

                System.out.println("Server >> " + inputStr);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("ClientReceiver 종료");
    }
}