public class StaticCount {
    static int count = 0;
    StaticCount(){
        StaticCount.count++;
    }
    public static void main(String[] args) {
        StaticCount c1 = new StaticCount();
        StaticCount c2 = new StaticCount();
        StaticCount c3 = new StaticCount();
        System.out.println(StaticCount.count);
    }
}