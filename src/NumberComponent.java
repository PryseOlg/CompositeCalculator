public class NumberComponent implements Component{
    private final double number;

    public NumberComponent(double number) {
        this.number = number;
    }

    @Override
    public double calculate() {
        return number;
    }
}
