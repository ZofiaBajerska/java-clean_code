import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.Date;


public class Message implements Comparable {

    private String title;
    private String author;
    private String text;
    private LocalDateTime date;

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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isComplete() {
        if ((author == null) || (title == null) || (text == null) || (date == null)) {
            return false;
        }
        if (author.equals("") || title.equals("") || text.equals("")){
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        Message message = (Message)o;
        int comp = 0;
        if(message.getTitle() != null) {
            comp = title.compareTo(message.getTitle());
            if (comp != 0) {
                return comp;
            }
        }
        if(message.getAuthor() != null) {
            comp = author.compareTo(message.getAuthor());
            if (comp != 0) {
                return comp;
            }
        }
        if (message.getText() != null) {
            comp = text.compareTo(message.getText());
            if (comp != 0) {
                return comp;
            }
        }
        if (message.getDate() != null) {
            comp = date.compareTo(message.getDate());
        }
        return comp;
    }
}
