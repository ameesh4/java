public class Students{
    String fname;
    String lname;
    int age;

    Students(){
        fname = "Amish";
        lname = "Sharma";
        age = 20;
    }

    Students(String fname, String lname, int age){
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }
    

    public static void main(String[] args) {
        Students student = new Students();

        System.out.println(student.fname);
        System.out.println(student.lname);
        System.out.println(student.age);
    }
}