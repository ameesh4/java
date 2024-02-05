import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Form{
    protected ArrayList<JLabel> label = new ArrayList<JLabel>();
    JPanel panel;
    protected ArrayList<JTextField> tField = new ArrayList<JTextField>();
    JButton button;
    ResultSet rset;

    public void setPanel(JPanel panel, int row, int column){
        panel.setLayout(new GridLayout(row, column));
        this.panel = panel;
    }

    public Form addLabel(String s){
        JLabel label1 = new JLabel(s);
        this.label.add(label1);
        this.panel.add(label1);
        return this;
    }

    public Form addtField(){
        JTextField txtField = new JTextField();
        // tField = new JTextField[]
        this.panel.add(txtField);
        this.tField.add(txtField);
        return this;
    }

    public Form addtField(KeyListener e){
        JTextField txtField = new JTextField();
        txtField.addKeyListener(e);
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
    Connection connection = null;
    PreparedStatement preStmt;

    public DBForm(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/formjava", "root", "Amish.com234");
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }catch(SQLException e){
            System.out.println(e);
        }
        
    }

    public boolean write(){
        try{
            String s = "INSERT INTO form(FirstName, LastName, EmailAddress, Country, PhoneNumber, DateOfBirth, Gender, localaddress, City, PostalCode) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            preStmt = connection.prepareStatement(s);
            for (int i = 0; i < 10; i++){
                preStmt.setString(i + 1, tField.get(i).getText());
            }
            preStmt.executeUpdate();
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

    public String getCountryCode(){
        String query = "select countryCode from countryId where country=?;";
        String result = "";
        try{
            preStmt = connection.prepareStatement(query);
            preStmt.setString(1, tField.get(3).getText());
            rset = preStmt.executeQuery();
        }catch(SQLException e){
            System.out.println(e);
        }
        
        try{
            result = rset.getString(1);
        }catch(SQLException e){
            System.out.println(e);
        }
        return result;
    }

    public void setCountryCode(){
        label.get(5).setText("+"+getCountryCode());
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
            .addLabel("Country:")
            .addtField(new KeyListener() {
                public void keyPressed(KeyEvent e){
                    form.setCountryCode();
                }
                public void keyReleased(KeyEvent e){}
                public void keyTyped(KeyEvent e){
                }
            })
            .addLabel("Country code:")
            .addLabel("")
            .addLabel("Phone Number:")
            .addtField()
            .addLabel("Date Of Birth:")
            .addtField()
            .addLabel("Gender:")
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
