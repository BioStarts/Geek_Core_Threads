public class MainClass {
    public static void main(String[] args) throws Exception {
        Threads second = new Threads();
        second.two();
        noThread first = new noThread();
        first.noTread();
    }
}
