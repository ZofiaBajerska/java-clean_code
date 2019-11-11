package model;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class MessageBuilder {
    private Message message = new Message();

    public MessageBuilder withTitle (final String title) {
        message.setTitle(title);
        return this;
    }

    public MessageBuilder withAuthor (final String author) {
        message.setAuthor(author);
        return this;
    }

    public MessageBuilder withText (final String text) {
        message.setText(text);
        return this;
    }

    public MessageBuilder withDate (final Date date) {
        message.setDate(date);
        return this;
    }

    public Message build(){
        return message;
    }
}
