package filter;

import model.Message;

import java.util.function.Predicate;

public class ByTextPredicate implements Predicate<Message> {
    private String text;

    public ByTextPredicate(String text){
        this.text = text;
    }

    @Override
    public boolean test(Message message) {
        return this.text.equals(message.getText());
    }
}
