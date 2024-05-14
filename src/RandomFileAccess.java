import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
public class RandomFileAccess {
    public static void main(String[] args) {
        String filePath = "src/file1.txt";
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw");
            randomAccessFile.seek(0);
            randomAccessFile.writeUTF("Test");
            randomAccessFile.seek(0);
            String message = randomAccessFile.readUTF();
            System.out.println("Đọc từ file: " + message);
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.writeUTF("Test 2");
            randomAccessFile.seek(0);
            System.out.println("Thông điệp của file là: " + randomAccessFile.readUTF());
            while (randomAccessFile.getFilePointer() < randomAccessFile.length()) {
                System.out.println(randomAccessFile.readUTF());
            }
            randomAccessFile.close();
        } catch (FileNotFoundException e) {
            System.err.println("Không tìm thấy file" + e.getMessage());
        } catch (IOException e) {
            System.err.println("Lỗi xử lý file" + e.getMessage());
        }

    }
}
