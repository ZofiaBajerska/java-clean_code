package model;

import org.jetbrains.annotations.NotNull;
import java.time.LocalDateTime;

public class Message {

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
/*
    public boolean isComplete() {
        if ((author == null) || (title == null) || (text == null) || (date == null)) {
            return false;
        }
        if (author.equals("") || title.equals("") || text.equals("")){
            return false;
        }
        return true;
    }

 */
}
