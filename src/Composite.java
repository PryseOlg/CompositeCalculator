import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Composite implements Component{
    private final List<Component> operations = new ArrayList<>();
    public Composite(Component...components) {
        operations.addAll(Arrays.asList(components));
    }
    public void appendChild(Component component) {
        operations.add(component);
    }
    public void removeChild(Component component) {
        operations.remove(component);
    }

    @Override
    public double calculate() {
        return operations.stream().mapToDouble(Component::calculate).sum();
    }
}
