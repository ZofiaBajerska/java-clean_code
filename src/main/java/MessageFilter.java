import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MessageFilter {

    private Message pattern = new Message();

    public void setTitle(String title) {
        pattern.setTitle(title);
    }

    public void setAuthor(String author) {
        pattern.setAuthor(author);
    }

    public void setText(String text) {
        pattern.setText(text);
    }

    public void setDate(Date date) {
        pattern.setDate(date);
    }

    public List<Message> process(List<Message> originalList) {
        return originalList.stream().filter(m -> m.compareTo(pattern) == 0).collect(Collectors.toList());
    }

}
