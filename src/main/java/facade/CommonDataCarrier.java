package facade;

import model.Message;

import java.util.function.Predicate;

public class CommonDataCarrier {

    private Predicate<Message> predicate;

    public Predicate<Message> getPredicate() {
        return predicate;
    }

    public void setPredicate(Predicate<Message> predicate) {
        this.predicate = predicate;
    }



}
