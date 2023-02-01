public class Sum implements Component {
    private final Component x;
    private final Component y;

    public Sum(Component x, Component y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double calculate() {
        return x.calculate() + y.calculate();
    }
}
