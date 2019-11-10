package filter;

import model.Message;

import java.time.LocalDateTime;
import java.util.function.Predicate;

public class ByDatePredicate implements Predicate<Message> {
    private LocalDateTime date;

    public ByDatePredicate(LocalDateTime date){
        this.date = date;
    }

    @Override
    public boolean test(Message message) {
        return this.date.equals(message.getDate());
    }
}
