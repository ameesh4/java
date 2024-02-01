import java.sql.*;

public class insertingindb {
    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Amish.com234");
            PreparedStatement prestmt;
            String s = "INSERT INTO testtable(Name, class) VALUES (?, ?)";
            prestmt = connection.prepareStatement(s);
            prestmt.setString(1, "Amish");
            prestmt.setString(2, "BESE2022");

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}