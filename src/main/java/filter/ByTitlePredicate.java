package filter;

import model.Message;

import java.util.function.Predicate;

public class ByTitlePredicate implements Predicate<Message> {

    private String title;

    public ByTitlePredicate(String title){
        this.title = title;
    }

    @Override
    public boolean test(Message message) {
        return this.title.equals(message.getTitle());
    }
}
