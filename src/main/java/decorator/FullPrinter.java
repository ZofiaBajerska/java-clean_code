package decorator;

import model.Message;

import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;

public class FullPrinter implements Consumer<Message> {

    @Override
    public void accept(Message message) {
        String out = "Date: " + message.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                + "\nAuthor: " + message.getAuthor()
                + "\nTitle: " + message.getTitle()
                + "\nText: " + message.getText()
                + "\n";
        System.out.println(out);
    }
}
