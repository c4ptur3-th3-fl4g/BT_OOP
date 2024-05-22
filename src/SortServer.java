
import java.io.*;
import java.net.*;
import java.util.Arrays;
public class SortServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server started on port 8080");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress());
                new ServerThread(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class ServerThread extends Thread {
    private Socket socket;
    public ServerThread(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        try (ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream())) {
            int[] numbers = (int[]) input.readObject();
            System.out.println("Received Array: " + Arrays.toString(numbers));
            Arrays.sort(numbers);
            System.out.println("Sending Array: " + Arrays.toString(numbers));
            output.writeObject(numbers);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
