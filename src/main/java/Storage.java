import java.util.ArrayList;
import java.util.List;

public final class Storage {
    private static final Storage INSTANCE = new Storage();
    private List<Message> container = new ArrayList<Message>();

    private Storage() {}
    public static Storage getInstance() {
        return INSTANCE;
    }

    public void add(Message msg) {
        if(msg ==null){
            throw new NullPointerException();
        }
        container.add(msg);
    }

    public boolean remove(Message msg) {
        return container.remove(msg);
    }

    public List<Message> getAll() {
        return List.copyOf(container);

    }
}
