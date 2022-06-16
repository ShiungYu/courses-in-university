import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.lang.Integer;

public class ServerClient {
    public static void main(String[] args) {
        InputStreamReader isr;
        BufferedReader br;
        OutputStreamWriter osw;
        BufferedWriter bw;
        String str;
        Scanner in = new Scanner(System.in);
        try {
            ServerSocket server = new ServerSocket(4444);// 在本机的4444port開放Server
            Socket socket = server.accept();// 只要產生連接，socket便可以代表所連接的那个物體，同時這個server.accept()只有產生了連接才會進行下一步操作。
            System.out.println(socket.getInetAddress());// 输出連接者的IP。
            System.out.println("建立了一個連接！");
            while (true) {
                isr = new InputStreamReader(socket.getInputStream());
                br = new BufferedReader(isr);
                str = br.readLine();
                System.out.println(socket.getInetAddress() + ": n:" + str);
                int n = Integer.parseInt(str);
                osw = new OutputStreamWriter(socket.getOutputStream());
                bw = new BufferedWriter(osw);
                if (n < 0) {
                    System.out.println("輸入負數,關閉");
                    bw.write("輸入關閉" + "\n");
                    bw.flush();
                    bw.close();
                    osw.close();
                    br.close();
                    isr.close();
                    break;
                } else {
                    int ans = Fibonacci(n);
                    System.out.println("回覆: Fibonacci第n個數為:" + ans);
                    bw.write(Integer.toString(ans) + "\n");
                    bw.flush();
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        int a1 = 1;
        int a2 = 1;
        int ans = 1;
        for (int i = 3; i <= n; i++) {
            if (i % 2 == 0) {
                a2 += a1;
                ans = a2;
            } else {
                a1 += a2;
                ans = a1;
            }
        }
        return ans;
    }
}