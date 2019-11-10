package facade;

import action.Remover;
import model.Message;
import storage.Storage;

import java.util.Scanner;
import java.util.function.Predicate;

public class ActionRemove implements UserAction {
    private Storage storage;
    private Scanner scanner;
    private Predicate<Message> predicate;

    public ActionRemove(Storage storage, Scanner scanner, Predicate<Message> predicate) {
        this.storage = storage;
        this.scanner = scanner;
        this.predicate = predicate;
    }

    @Override
    public String getInfo() {
        return "Remove messages";
    }

    @Override
    public void execute() {
        System.out.println("Do You really want to remove? (Y/N)");
        String decision = scanner.nextLine();
        if (decision.contains("y") || decision.contains("Y")){
            Remover remover = new Remover(predicate);
            remover.execute(storage);
            System.out.println("Messages removed!");
        }
        else{
            System.out.println("Messages not removed!");
        }
    }
}