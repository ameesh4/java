import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Form{
    JLabel label;
    JPanel panel;
    JTextField tField;
    JButton button;

    Form(JPanel panel, int row, int column){
        panel.setLayout(new GridLayout(row, column));
        this.panel = panel;
    }

    public Form addLabel(String s){
        this.label = new JLabel(s);
        this.panel.add(this.label);
        return this;
    }

    public Form addLabel(){
        this.label = new JLabel();
        return this;
    }

    public Form addtField(){
        this.tField = new JTextField();
        this.panel.add(this.tField);
        return this;
    }

    public Form addButton(String s){
        this.button = new JButton(s);
        this.button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(new JFrame(), "Submitted");
            }
        });
        this.panel.add(this.button);
        return this;
    }

    public JPanel getForm(){
        return this.panel;
    }
    
}


public class FormImplementation {
    public static void main(String[] args) {
        Form form = new Form(new JPanel(), 4, 2);
        form.addLabel("Name")
            .addtField()
            .addLabel("Roll")
            .addtField()
            .addLabel("Class")
            .addtField()
            .addButton("Submit");

        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.add(form.getForm(), BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
    }
}
