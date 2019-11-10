package facade;

import model.MessageBuilder;
import storage.Storage;

import java.time.LocalDateTime;
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
    public void execute() {
        MessageBuilder builder = new MessageBuilder();
        System.out.print("Author: ");
        builder.withAuthor(scanner.nextLine());
        System.out.print("Title: ");
        builder.withTitle(scanner.nextLine());
        System.out.print("Text: ");
        builder.withText(scanner.nextLine());
        builder.withDate(LocalDateTime.now());

        storage.add(builder.build());
    }
}
