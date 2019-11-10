package filter;

import model.Message;

import java.util.function.Predicate;

public class ByAuthorPredicate implements Predicate<Message> {
    private String author;

    public ByAuthorPredicate(String author){
        this.author = author;
    }

    @Override
    public boolean test(Message message) {
        return this.author.equals(message.getAuthor());
    }
}
