package filter;

import model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ComplexPredicate implements Predicate<Message> {
    private List<Predicate> predicates = new ArrayList<>();

    public void addPredicate(Predicate<Message> predicate) {
        if (predicate != null) {
            predicates.add(predicate);
        }
    }

    @Override
    public boolean test(Message message) {
        for (Predicate predicate : predicates) {
            if (!predicate.test(message)){
                return false;
            }
        }
        return true;
    }
}
