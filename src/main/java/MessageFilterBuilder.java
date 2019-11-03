import java.util.Date;

public class MessageFilterBuilder {

    private String title;
    private String author;
    private String text;
    private Date date;

    /**public MessageFilterBuilder()
    {
        title;
        author = "b";
        text = "c";
    }**/

    public MessageFilterBuilder withTitle (final String title) {
        this.title = title;
        return this;
    }

    public MessageFilterBuilder withAuthor (final String author) {
        this.author =author;
        return this;
    }

    public MessageFilterBuilder withText (final String text) {
        this.text = text;
        return this;
    }

    public MessageFilterBuilder withDate (final Date date) {
        this.date = date;
        return this;
    }
    public MessageFilter build(){
        final MessageFilter filter = new MessageFilter();
        filter.setTitle(title);
        filter.setAuthor(author);
        filter.setText(text);
//        filter.setDate(date);
        return filter;
    }
}
