class User{
    String fname;
    String lname;
    int age;

    public User(){
            fname = "Amish";
            lname = "Sharma";
            age = 20;
    }

    public User(String fname, String lname, int age){
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }

    public User(User user){
        user.fname = "Ayush";
        user.lname = "Shrestha";
        user.age = 18;
    }

    public String toString(){
        return (fname + "\n" + lname + "\n" + age );
    }
}

public class CopyConstructors {
    public static void main(String[] args) {
        User user1 = new User();
        System.out.println(user1);
        User user2 = new User(user1);
        System.out.println(user1);
        User user3 = new User("Ram", "Baral", 50);
        System.out.println(user3);
    }
}
