import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Form{
    JLabel label;
    JPanel panel;
    protected ArrayList<JTextField> tField = new ArrayList<JTextField>();
    JButton button;
    static int i = 0;

    public void setPanel(JPanel panel, int row, int column){
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
        JTextField txtField = new JTextField();
        // tField = new JTextField[]
        this.panel.add(txtField);
        this.tField.add(txtField);
        return this;
    }

    public Form addButton(String s, ActionListener e){
        this.button = new JButton(s);
        this.button.addActionListener(e);
        this.panel.add(this.button);
        return this;
    }

    public JPanel getForm(){
        return this.panel;
    }
}

class DBForm extends Form{
    public boolean write(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/formjava", "root", "Amish.com234");
            PreparedStatement preStmt;
            String s = "INSERT INTO form(FirstName, LastName, EmailAddress, PhoneNumber, DateOfBirth, Gender, Country, localaddress, City, PostalCode) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            preStmt = connection.prepareStatement(s);
            for (int i = 0; i < 10; i++){
                preStmt.setString(i + 1, tField.get(i).getText());
            }
            preStmt.executeUpdate();
            // connection.commit();
        }
        // catch(ClassNotFoundException e){
        //     System.out.println(e);
        //     return false;
        // }
        catch(SQLException e){
            System.out.println(e);
            return false;
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
        finally{
            try{
                connection.close();
            }
            catch(SQLException e){
                System.out.println(e);
            }
            catch(NullPointerException e){
                System.out.println(e);
            }
        }
        return true;
    }
}

public class FormImplementation{
    
    public static void main(String[] args) {
        DBForm form = new DBForm();
        form.setPanel(new JPanel(), 12, 2);
        form.addLabel("First Name:")
            .addtField()
            .addLabel("Last Name:")
            .addtField()
            .addLabel("Email Address:")
            .addtField()
            // .addLabel("Country code:")
            // .addtField()
            .addLabel("Phone Number:")
            .addtField()
            .addLabel("Date Of Birth:")
            .addtField()
            .addLabel("Gender:")
            .addtField()
            .addLabel("Country:")
            .addtField()
            .addLabel("Local Address:")
            .addtField()
            .addLabel("City:")
            .addtField()
            .addLabel("Postal Code:")
            .addtField()
            .addButton("Submit", new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    if(form.write()){
                        System.out.println("Successfully Inserted data");
                    }
                    else{
                        System.out.println("Error Inserting Data");
                    }
                }
            });

        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.add(form.getForm(), BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
    }
}
