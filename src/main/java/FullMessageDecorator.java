import model.Message;

import java.time.format.DateTimeFormatter;

public class FullMessageDecorator implements MessageDecorator {

    private Message message;

    public FullMessageDecorator (Message message){
        this.message = message;
    }


    @Override
    public String getRecord() {
        String line = "Date: " + message.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                + "\nAuthor: " + message.getAuthor()
                + "\nTitle: " + message.getTitle()
                + "\nText: " + message.getText()
                + "\n";
        return line;
    }
}
