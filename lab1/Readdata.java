import java.io.*;

public class Readdata {

    public int getInt() {
        int num = 0;
        System.out.println("Enter a number");
        String line = "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            line = in.readLine();
            num = Integer.parseInt(line);
        } catch (Exception e) {
            System.err.println("IO error" + e);
        }
        return num;
    }

    public static void main(String[] args) {
        Readdata p = new Readdata();
        int a = p.getInt();
        int b = p.getInt();

        System.out.println("Sum = " + (a + b));

    }
}