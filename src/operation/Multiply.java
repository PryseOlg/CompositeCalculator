package operation;

public class Multiply extends Operation {
    public Multiply(Component value1, Component value2) {
        super(value1, value2);
    }

    @Override
    public String toString() {
        return "Multiply(" + value1.toString() + ", " + value2.toString() + ")";
    }

    @Override
    public double getValue() {
        return value1.getValue() * value2.getValue();
    }
}
