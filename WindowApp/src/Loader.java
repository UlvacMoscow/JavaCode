import javax.swing.*;
import java.awt.*;

/**
 * Created by арсений on 18.10.2017.
 */
public class Loader {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Our first window application");
        frame.setVisible(true);
        System.out.println("some text");
    }
}
