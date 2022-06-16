import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.lang.Integer;

public class ClientSocket {
    public static void main(String[] args) {
        InputStreamReader isr;
        BufferedReader br;
        OutputStreamWriter osw;
        BufferedWriter bw;
        String str;
        Scanner in = new Scanner(System.in);

        try {
            Socket socket = new Socket("localhost", 4444);
            System.out.println("成功連接");
            while (true) {
                osw = new OutputStreamWriter(socket.getOutputStream());
                bw = new BufferedWriter(osw);
                System.out.print("請輸入正整數，或以負數結束連線，n:");
                str = in.nextLine();
                bw.write(str + "\n");
                bw.flush();
                isr = new InputStreamReader(socket.getInputStream());
                br = new BufferedReader(isr);
                String receiveStr = br.readLine();
                if (receiveStr.equals("輸入關閉")) {
                    System.out.println(socket.getInetAddress() + ": " + receiveStr);
                    bw.close();
                    osw.close();
                    br.close();
                    isr.close();
                    socket.close();
                    break;
                }
                System.out.println(socket.getInetAddress() + ": Fibonacci第" + str + "個數為:" + receiveStr);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}