package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.Charset;

class ServerReciever extends Thread {

    private final Socket socket;

    public ServerReciever(Socket socket) {
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
                    System.out.println("클라이언트에서 연결을 해제");
                    ServerEx.running = false;
                    break;
                }

                System.out.println("Client >> " + inputStr);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("ServerReceiver 종료");
    }
}