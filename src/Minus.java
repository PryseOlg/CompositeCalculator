public class Minus implements Component {
    private final Component x;
    private final Component y;

    public Minus(Component x, Component y) {
        this.y = y;
        this.x = x;
    }

    @Override
    public double calculate() {
        return x.calculate() - y.calculate();
    }
}
