package decorator;

import model.Message;

import java.text.SimpleDateFormat;
import java.util.function.Consumer;

public class FullPrinter implements Consumer<Message> {
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yy HH:mm:ss");

    @Override
    public void accept(Message message) {

        String out = "Date: " + simpleDateFormat.format(message.getDate())
                + "\nAuthor: " + message.getAuthor()
                + "\nTitle: " + message.getTitle()
                + "\nText: " + message.getText()
                + "\n";
        System.out.println(out);
    }
}
