import decorator.FullPrinter;
import decorator.SimplePrinter;
import filter.ByAnyPredicate;
import filter.FilterBuilder;
import model.Message;
import storage.Storage;

import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.List;

public class StorageFacade {

    private static final StorageFacade INSTANCE = new StorageFacade();
    private Storage storage = Storage.getInstance();
    private ByAnyPredicate filter;

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
                out.println(new FullPrinter(m).getRecord()); });
        }
        else {
            storage.getAll().stream().forEach(m -> {
                out.println(new SimplePrinter(m).getRecord()); });
        }
    }

    public void showSelected(boolean fullInfo, PrintStream out) {
        if (fullInfo) {
            List<Message> selected = filter.process(storage.getAll());
            selected.forEach(m -> { out.println(new FullPrinter(m).getRecord()); });
        }
        else {
            List<Message> selected = filter.process(storage.getAll());
            selected.forEach(m -> { out.println(new SimplePrinter(m).getRecord()); });
        }
    }

    public void setFilter(String author, String title, String text, LocalDateTime stamp) {
        FilterBuilder mfb = new FilterBuilder();
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
