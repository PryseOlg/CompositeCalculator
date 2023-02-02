package operation;

public abstract class Operation extends Component{
    protected final Component value1;
    protected final Component value2;

    public Operation(Component value1, Component value2) {
        this.value1 = value1;
        this.value2 = value2;
    }
}
