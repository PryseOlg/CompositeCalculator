public class Main {
    public static void main(String[] args) {
        Component one = new Division(new NumberComponent(5), new NumberComponent(4));
        System.out.println(one.calculate());
        Component two = new Sum(new NumberComponent(1), new Sum(new NumberComponent(3), new NumberComponent(4)));
        System.out.println(two.calculate());

    }
}