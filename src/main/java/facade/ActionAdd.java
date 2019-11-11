package facade;

import input.InputReader;
import input.StringValidator;
import model.MessageBuilder;
import storage.Storage;

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

    @Override
    public boolean execute() {
        MessageBuilder builder = new MessageBuilder();

        InputReader<String> reader = new InputReader<>(new StringValidator());
        builder.withAuthor(reader.getValue("Author: ", scanner));
        builder.withTitle(reader.getValue("Title: ", scanner));
        builder.withText(reader.getValue("Text: ", scanner));
        builder.withDate(new Date());

        storage.add(builder.build());
        return true;
    }
}
