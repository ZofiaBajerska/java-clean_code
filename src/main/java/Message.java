import org.jetbrains.annotations.NotNull;

import java.util.Date;


public class Message implements Comparable {

    private String title;
    private String author;
    private String text;
    private Date date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        Message message = (Message)o;
        int comp = title.compareTo(message.getTitle());
        if ((comp != 0) &&(message.getTitle() != null)) {
            return comp;
        }
        comp = author.compareTo(message.getAuthor());
        if ((comp != 0) &&(message.getAuthor() != null)) {
            return comp;
        }
        comp = text.compareTo(message.getText());
        if ((comp != 0) &&(message.getText() != null)) {
            return comp;
        }
        comp = date.compareTo(message.getDate());
        if ((message.getDate() == null)){
            return 0;
        }
        return comp;
    }
}
