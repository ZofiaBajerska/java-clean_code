package facade;

import filter.ComplexFilterBuilder;
import model.Message;
import storage.Storage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.function.Predicate;

public class ActionBuildFilter implements UserAction {

    private Storage storage;
    private Scanner scanner;
    private Predicate<Message> predicate;

    public ActionBuildFilter(Storage storage, Scanner scanner, Predicate<Message> predicate) {
        this.storage = storage;
        this.scanner = scanner;
        this.predicate = predicate;
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public void execute() {
        System.out.println("You can choose by any of following (i.e. AE):\n"
                + "Author(A)\n" + "Title(T)\n" + "Text(E)\n" + "Date(D)");
        String filterSet = scanner.nextLine();
        ComplexFilterBuilder builder = new ComplexFilterBuilder();
        if(filterSet.contains("a") || filterSet.contains("A")) {
            System.out.print("Author: ");
            builder.withAuthor(scanner.nextLine());
        }
        if(filterSet.contains("t") || filterSet.contains("T")) {
            System.out.print("Title: ");
            builder.withTitle(scanner.nextLine());
        }
        if(filterSet.contains("e") || filterSet.contains("E")) {
            System.out.print("Text: ");
            builder.withText(scanner.nextLine());
        }
        if (filterSet.contains("d") || filterSet.contains("D")) {
            System.out.print("Date: ");
            //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            builder.withDate(LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        }
        predicate = builder.build();
    }
}
