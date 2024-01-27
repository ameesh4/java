import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = 0;
        int b = 0;
        String line = "";
        System.out.println("Enter value for a");
        line = in.next();
        try {
            a = Integer.parseInt(line);
            System.out.println("Enter value for b");
            line = in.next();
            b = Integer.parseInt(line);
            float c = 0;
            c = a / b;
            System.out.println("c = " + c);
        } catch (NumberFormatException e) {
            System.out.println("Unhandled input " + e);
            System.exit(1);
        } catch (ArithmeticException e) {
            System.out.println("Division error " + e);
        }
            
        
        in.close();
    }
}
