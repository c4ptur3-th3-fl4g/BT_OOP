import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class FileProcess {
    public static void main(String[] args) {
        String sourceFilePath = "src/file1.txt";
        String destinationFilePath = "src/file2.txt";
        try (FileInputStream fileInputStream = new FileInputStream(sourceFilePath); FileOutputStream fileOutputStream = new FileOutputStream(destinationFilePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("File copied successfully");
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        } 
    }

}

