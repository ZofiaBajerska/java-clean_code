package action;

import model.Message;
import storage.Storage;

import java.util.function.Predicate;

public class Remover {
    private Predicate<Message> predicate;

    public Remover(Predicate<Message> predicate){
        this.predicate = predicate;
    }

    public boolean execute(Storage storage){
        return storage.getMessages().removeIf(predicate);
    }
}
