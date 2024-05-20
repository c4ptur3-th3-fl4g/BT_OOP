import java.io.*;
import java.net.*;
class java_tcp {
    public static void main(String[] args) {
        String host = "localhost";
        if (args.length > 0) {
            host = args[0];
        }
        for (int i = 1; i < 1024; i++) {
            try {
                Socket s = new Socket(host, i);
                System.out.println("Cổng " + i + " đang mở");
            } catch (UnknownHostException e) {
                System.err.println(e);
                break;
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}