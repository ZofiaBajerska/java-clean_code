import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.List;

public class StorageFacade {

    private static final StorageFacade INSTANCE = new StorageFacade();
    private Storage storage = Storage.getInstance();
    private MessageFilter filter;

    private StorageFacade(){}
    public static StorageFacade getInstance() {
        return INSTANCE;
    }

    public boolean add(String author, String title, String text, LocalDateTime stamp){
        Message newMsg = new Message();
        newMsg.setAuthor(author);
        newMsg.setTitle(title);
        newMsg.setText(text);
        newMsg.setDate(stamp);
        if (newMsg.isComplete()) {
            storage.add(newMsg);
            return true;
        }
        return false;
    }

    public void showAll(boolean fullInfo, PrintStream out) {
        if (fullInfo) {
            storage.getAll().stream().forEach(m -> {
                out.println(new FullMessageDecorator(m).getRecord()); });
        }
        else {
            storage.getAll().stream().forEach(m -> {
                out.println(new SimpleMessageDecorator(m).getRecord()); });
        }
    }

    public void showSelected(boolean fullInfo, PrintStream out) {
        if (fullInfo) {
            List<Message> selected = filter.process(storage.getAll());
            selected.forEach(m -> { out.println(new FullMessageDecorator(m).getRecord()); });
        }
        else {
            List<Message> selected = filter.process(storage.getAll());
            selected.forEach(m -> { out.println(new SimpleMessageDecorator(m).getRecord()); });
        }
    }

    public void setFilter(String author, String title, String text, LocalDateTime stamp) {
        MessageFilterBuilder mfb = new MessageFilterBuilder();
        mfb.withAuthor(author);
        mfb.withTitle(title);
        mfb.withText(text);
        mfb.withDate(stamp);
        filter = mfb.build();
    }

    public boolean removedSelected(){
        List<Message> selected = filter.process(storage.getAll());
        selected.stream().forEach(storage::remove);
        return true;
    }
}
