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
        this.fname = user.fname;
        this.lname = user.lname;
        this.age = user.age;
    }

    public String toString(){
        return (fname + "\n" + lname + "\n" + age );
    }
}



public class Constructors {
    public static void main(String[] args) {
        User user1 = new User();
        User user2 = new User("Ayush", "Shrestha", 18);
        User user3 = new User(user1);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
    }
}
