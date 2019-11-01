public class FullMessageDecorator implements MessageDecorator {

    private Message message;

    public FullMessageDecorator (Message message){
        this.message = message;
    }


    @Override
    public String getRecord() {
        String line = "Date: " + message.getDate()
                + "\nAuthor: " + message.getAuthor()
                + "\nTitle: " + message.getTitle()
                + "\nText: " + message.getText()
                + "\n";
        return line;
    }
}
