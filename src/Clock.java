import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class Clock extends JFrame {
    private JLabel timeLabel;

    public Clock() {
        
        setTitle("Đồng Hồ Số");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 48));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        
        add(timeLabel);

        
        startClock();
    }

    private void startClock() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                
                String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
        
                timeLabel.setText(time);
            }
        }, 0, 1000); 
    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            Clock clock = new Clock();
            clock.setVisible(true);
        });
    }
}
