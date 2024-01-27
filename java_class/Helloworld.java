import java.util.Scanner;

class Student{
    public int roll;
    public String name;
    public static String className;
    public String toString(){
        return name;
    }
}

public class Helloworld {
    public static void main(String[] args) {
        Student s = new Student();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Name:");
        s.name = in.nextLine();
        // System.out.println(s.name);
        // System.out.println(Student.className);
        System.out.println(s);
    }
}


