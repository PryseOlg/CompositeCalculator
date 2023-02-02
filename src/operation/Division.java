package operation;

public class Division extends Operation {
    public Division(Component value1, Component value2) {
        super(value1, value2);
    }

    @Override
    public String toString() {
        return "Division(" + value1.toString() + ", " + value2.toString() + ")";
    }

    @Override
    public double getValue() {
        return value1.getValue() / value2.getValue();
    }
}
