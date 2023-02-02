package operation;

public class Subtraction extends Operation {
    public Subtraction(Component value1, Component value2) {
        super(value1, value2);
    }

    @Override
    public String toString() {
        return "Subtraction(" + value1.toString() + ", " + value2.toString() + ")";
    }

    @Override
    public double getValue() {
        return value1.getValue() - value2.getValue();
    }
}
