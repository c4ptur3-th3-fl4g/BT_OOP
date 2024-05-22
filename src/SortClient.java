import java.io.*;
import java.net.*;
import java.util.Arrays;
public class SortClient {
    public static void main(String[] args){
        String hostname = "localhost";
        int port = 8080;
        try (
            Socket socket = new Socket(hostname, port);
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream())) {
            int[] numbers = {1, 2, 3, 4, 5};
            System.out.print("Sending Array: " + Arrays.toString(numbers));
            output.writeObject(numbers);
            int[] sortedNumbers = (int[]) input.readObject();
            System.out.println("Received Array: " + Arrays.toString(sortedNumbers));
        } catch(UnknownHostException ex) {
            System.err.println("Server not found: " + ex.getMessage());
        }catch(IOException ex) {
            System.err.println("I/O error: " + ex.getMessage());
        }catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}