package filter;

import model.Message;

import java.util.Date;
import java.util.function.Predicate;

public class ByDatePredicate implements Predicate<Message> {
    private Date date;

    public ByDatePredicate(Date date){
        this.date = date;
    }

    @Override
    public boolean test(Message message) {
        return message.getDate().before(this.date);
    }
}
