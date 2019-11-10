package decorator;

import model.Message;

import java.util.function.Consumer;

public class SimplePrinter implements Consumer<Message> {

    @Override
    public void accept(Message message) {
        String out = "Author: " + message.getAuthor()
                + "\nTitle: " + message.getTitle()
                + "\n";
        System.out.println(out);
    }
}
