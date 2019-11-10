package facade;

import decorator.FullPrinter;
import decorator.SimplePrinter;
import filter.AlwaysTruePredicate;
import model.Message;
import storage.Storage;

import java.util.Scanner;
import java.util.function.Predicate;

public class ActionPrint implements UserAction {
    private Storage storage;
    private Scanner scanner;
    private CommonDataCarrier common;

    public ActionPrint(Storage storage, Scanner scanner) {
        this.storage = storage;
        this.scanner = scanner;
        common = new CommonDataCarrier();
        common.setPredicate(new AlwaysTruePredicate());
    }

    public ActionPrint(Storage storage, Scanner scanner, CommonDataCarrier common){
        this.storage = storage;
        this.scanner = scanner;
        this.common = common;
    }

    @Override
    public String getInfo() {
        return "Print messages";
    }

    @Override
    public void execute() {
        System.out.print("Do You want simple or full format? (S/F): ");
        String format = scanner.nextLine();
        if ((format.contains("s")) || (format.contains("S"))) {
            storage.getMessages().stream().filter(common.getPredicate()).forEach(new SimplePrinter());
        }
        else if ((format.contains("f")) || (format.contains("F"))) {
            storage.getMessages().stream().filter(common.getPredicate()).forEach(new FullPrinter());
        }
        else {
            System.out.println("Please try again!");
        }
    }
}
