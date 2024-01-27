import javax.swing.*;

public class LayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Main");
        // JPanel panel1 = new JPanel();
        frame.setSize(500, 500);
        frame.setExtendedState(frame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
