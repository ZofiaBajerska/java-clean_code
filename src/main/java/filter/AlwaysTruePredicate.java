package filter;

import model.Message;

import java.util.function.Predicate;

public class AlwaysTruePredicate implements Predicate<Message> {
    @Override
    public boolean test(Message message) {
        return true;
    }
}
