public class SimpleMessageDecorator implements MessageDecorator {

    private Message message;

    public SimpleMessageDecorator (Message message){
        this.message = message;
    }

    @Override
    public String getRecord() {
        String line = "Author: " + message.getAuthor()
                + "\nTitle: " + message.getTitle()
                + "\n";
        return line;
    }
}
