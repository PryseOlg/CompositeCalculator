public class Multiplication implements Component{
    private final Component x;
    private final Component y;

    public Multiplication(Component x, Component y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double calculate() {
        return x.calculate() * y.calculate();
    }
}

