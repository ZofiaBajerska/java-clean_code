package facade;

import model.MessageBuilder;
import storage.Storage;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class ActionAdd implements UserAction {
    private Storage storage;
    private Scanner scanner;

    public ActionAdd (Storage storage, Scanner scanner){
        this.storage = storage;
        this.scanner = scanner;
    }

    @Override
    public String getInfo() {
        return "Add message";
    }

    public String getValidInput(String tag){
        String input;
        do {
            System.out.print(tag);
            input = scanner.nextLine();
        } while (input.isEmpty());

        return input;
    }

    @Override
    public boolean execute() {
        MessageBuilder builder = new MessageBuilder();

        builder.withAuthor(getValidInput("Author: "));
        builder.withTitle(getValidInput("Title: "));
        builder.withText(getValidInput("Text: "));
        builder.withDate(new Date());

        storage.add(builder.build());
        return true;
    }
}
