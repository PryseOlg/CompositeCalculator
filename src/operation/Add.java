package operation;

public class Add extends Operation {
    public Add(Component value1, Component value2) {
        super(value1, value2);
    }

    @Override
    public String toString() {
        return "Add(" + value1.toString() + ", " + value2.toString() + ")";
    }

    @Override
    public double getValue() {
        return value1.getValue() + value2.getValue();
    }
}

