import javax.swing.*;
import java.awt.event.*;

public class javaActionListener {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Action Listener");
        JLabel tf = new JLabel();
        tf.setBounds(50, 50, 200, 30);
        JButton button = new JButton("Click Me");
        button.setBounds(50, 100, 200, 30);
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf.setText("Welcome Mate");
            }
        });
        frame.setSize(500, 500);
        frame.add(tf);frame.add(button);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
