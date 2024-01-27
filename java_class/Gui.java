import javax.swing.JOptionPane;

public class Gui {
    public static void main(String[] args) {
        String firstNumber = JOptionPane.showInputDialog("Enter first Integer");
        String secondNumber = JOptionPane.showInputDialog("Enter second Integer");

        int number1 = Integer.parseInt(firstNumber);
        int number2 = Integer.parseInt(secondNumber);
        int sum = number1 + number2;

        JOptionPane.showMessageDialog(null, "The Sum is" + sum, "Sum of Two Integers", JOptionPane.PLAIN_MESSAGE);
    }
}
