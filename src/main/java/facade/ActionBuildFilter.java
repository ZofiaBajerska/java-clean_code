package facade;

import filter.ComplexPredicateBuilder;
import input.DateTimeValidator;
import input.InputReader;
import input.StringValidator;
import storage.Storage;

import java.util.Date;
import java.util.Scanner;

public class ActionBuildFilter implements UserAction {

    private Storage storage;
    private Scanner scanner;
    private CommonDataCarrier common;

    public ActionBuildFilter(Storage storage, Scanner scanner, CommonDataCarrier common) {
        this.storage = storage;
        this.scanner = scanner;
        this.common = common;
    }

    @Override
    public String getInfo() {
        return "Build filter";
    }

    @Override
    public boolean execute() {
        System.out.println("You can choose by any of following (i.e. AE):\n"
                + "Author(A)\n" + "Title(T)\n" + "Text(E)\n" + "Date(D)");
        String filterSet = scanner.nextLine();
        ComplexPredicateBuilder builder = new ComplexPredicateBuilder();
        if(filterSet.contains("a") || filterSet.contains("A")) {
            InputReader<String> reader = new InputReader<>(new StringValidator());
            builder.withAuthor(reader.getValue("Author: ", scanner));
        }
        if(filterSet.contains("t") || filterSet.contains("T")) {
            InputReader<String> reader = new InputReader<>(new StringValidator());
            builder.withTitle(reader.getValue("Title: ", scanner));
        }
        if(filterSet.contains("e") || filterSet.contains("E")) {
            InputReader<String> reader = new InputReader<>(new StringValidator());
            builder.withText(reader.getValue("Text: ", scanner));
        }
        if (filterSet.contains("d") || filterSet.contains("D")) {
            InputReader<Date> reader = new InputReader<>(new DateTimeValidator());
            builder.withDate(reader.getValue("Date: ", scanner));
        }
        common.setPredicate(builder.build());
        return true;
    }
}
