import java.util.Date;
import java.util.Scanner;

public class Application {

    Scanner scanner = new Scanner(System.in);

    Storage storage = Storage.getInstance();

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    public void run() {
        int cmd;
        do {
            System.out.println("1 add");
            System.out.println("2 print");
            System.out.println("3 filter");
            System.out.println("4 remove");
            System.out.println("5 quit");

            cmd = scanner.nextInt();
            scanner.skip("\n");

            switch (cmd) {
                case 1:
                    addMessage();
                    break;
                case 2:
                    showMessages();
                    break;
                case 3:
                    filterMessages();
                    break;
            }
        } while (cmd != 5);

    }

    private void addMessage() {
        Message newMsg = new Message();
        System.out.print("Author: ");
        newMsg.setAuthor(scanner.nextLine());
        System.out.print("Title: ");
        newMsg.setTitle(scanner.nextLine());
        System.out.print("Text: ");
        newMsg.setText(scanner.nextLine());
        newMsg.setDate(new Date(System.currentTimeMillis()));
        if (newMsg.isComplete()) {
            storage.add(newMsg);
        }
        else {
            System.out.println("Please try again!");
        }
    }

    private void showMessages() {
        System.out.print("Do You want simple or full format? (S/F): ");
        String format = scanner.nextLine();
        if ((format.contains("s")) || (format.contains("S"))) {
            storage.getAll().stream().forEach(m -> {
                System.out.println(new SimpleMessageDecorator(m).getRecord()); });
        }
        else if ((format.contains("f")) || (format.contains("F"))) {
            storage.getAll().stream().forEach(m -> {
                System.out.println(new FullMessageDecorator(m).getRecord()); });
        }
        else {
            System.out.println("Please try again!");
        }
    }

    private void filterMessages() {
        MessageFilterBuilder mfb = new MessageFilterBuilder();
        System.out.println("You can filter by any of following (i.e. AE):\n"
        + "Author(A)\n" + "Title(T)\n" + "Text(E)\n" + "Date(D)");
        String filterSet = scanner.nextLine();
        if(filterSet.contains("a") || filterSet.contains("A")) {
            System.out.print("Author: ");
            mfb.withAuthor(scanner.nextLine());
        }
        if(filterSet.contains("t") || filterSet.contains("T")) {
            System.out.print("Title: ");
            mfb.withTitle(scanner.nextLine());
        }
        if(filterSet.contains("e") || filterSet.contains("E")) {
            System.out.print("Text: ");
            mfb.withText(scanner.nextLine());
        }
        /**if(filterSet.contains("d") || filterSet.contains("D")) {
            System.out.print("Date: ");
            mfb.withDate(scanner.nextLine());
        }**/

        MessageFilter mf = mfb.build();

        System.out.print("Do You want simple or full format? (S/F): ");
        String format = scanner.nextLine();
        if ((format.contains("s")) || (format.contains("S"))) {
            mf.process(storage.getAll()).stream().forEach(m -> {
                System.out.println(new SimpleMessageDecorator(m).getRecord()); });
        }
        else if ((format.contains("f")) || (format.contains("F"))) {
            mf.process(storage.getAll()).stream().forEach(m -> {
                System.out.println(new FullMessageDecorator(m).getRecord()); });
        }
        else {
            System.out.println("Please try again!");
        }
    }

}
