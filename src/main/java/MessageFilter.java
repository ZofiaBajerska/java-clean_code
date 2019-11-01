import java.util.Date;

public class MessageFilter {

    private Message filter;

    public void setTitle(String title) {
        filter.setTitle(title);
    }

    public void setAuthor(String author) {
        filter.setAuthor(author);
    }

    public void setText(String text) {
        filter.setText(text);
    }

    public void setDate(Date date) {
        filter.setDate(date);
    }

}
