import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
public class ByteArray {
    public static void main(String[] args) {
        byte[] inputData = "Bai Tap OOP".getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(inputData);
        } catch (IOException e) {
            System.err.println("Error writing to ByteArrayOutputStream: " + e.getMessage());
        }
        byte[] outputData = byteArrayOutputStream.toByteArray();
        System.out.println("Output Data: " + new String(outputData));
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(outputData);
        byte[] buffer = new byte[1024];
        int bytesRead;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while ((bytesRead = byteArrayInputStream.read(buffer)) != -1) {
                stringBuilder.append(new String(buffer, 0, bytesRead));
            }
        } catch (IOException e) {
            System.err.println("Error reading from ByteArrayInputStream: " + e.getMessage());
        }
        
    }

}


