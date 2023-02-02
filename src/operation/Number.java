package operation;

public class Number extends Component {
    private final double value;

    @Override
    public String toString() {
        return "Number(" + (int) value + ")";
    }

    @Override
    public double getValue() {
        return value;
    }

    public Number(double value) {
        this.value = value;
    }
}
