package storage;

import model.Message;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final Storage INSTANCE = new Storage();
    private List<Message> messages = new ArrayList<>();

    private Storage() {}
    public static Storage getInstance() {
        return INSTANCE;
    }

    public void add(Message msg) {
        if(msg == null){
            throw new NullPointerException();
        }
        messages.add(msg);
    }

    public List<Message> getMessages() {
        return messages;
    }
}
