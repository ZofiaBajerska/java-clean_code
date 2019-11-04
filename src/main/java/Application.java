import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Application {

    private StorageFacade systemFacade;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        int cmd;
        systemFacade = StorageFacade.getInstance();
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
                case 4:
                    removeMessages();
                    break;
                case 5:
                    System.out.println("Good bay!");
                    break;
                default:
                    System.out.println("Invalid operation");
                    break;
            }
        } while (cmd != 5);

    }

    private void addMessage() {
        String author, title, text;
        System.out.print("Author: ");
        author = scanner.nextLine();
        System.out.print("Title: ");
        title = scanner.nextLine();
        System.out.print("Text: ");
        text = scanner.nextLine();

        if (systemFacade.add(author, title, text, LocalDateTime.now())) {
            System.out.println("Message added!");
        }
        else {
            System.out.println("Please try again!");
        }

    }

    private void showMessages() {
        System.out.print("Do You want simple or full format? (S/F): ");
        String format = scanner.nextLine();
        if ((format.contains("s")) || (format.contains("S"))) {
            systemFacade.showAll(false, System.out);
        }
        else if ((format.contains("f")) || (format.contains("F"))) {
            systemFacade.showAll(true, System.out);
        }
        else {
            System.out.println("Please try again!");
        }
    }

    private void setUserFilter() {
        System.out.println("You can choose by any of following (i.e. AE):\n"
                + "Author(A)\n" + "Title(T)\n" + "Text(E)\n" + "Date(D)");
        String filterSet = scanner.nextLine();
        String author = null;
        String title = null;
        String text = null;
        LocalDateTime stamp = null;
        if(filterSet.contains("a") || filterSet.contains("A")) {
            System.out.print("Author: ");
            author = scanner.nextLine();
        }
        if(filterSet.contains("t") || filterSet.contains("T")) {
            System.out.print("Title: ");
            title = scanner.nextLine();
        }
        if(filterSet.contains("e") || filterSet.contains("E")) {
            System.out.print("Text: ");
            text = scanner.nextLine();
        }
        if (filterSet.contains("d") || filterSet.contains("D")) {
            System.out.print("Date: ");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd");
            stamp = LocalDateTime.parse(scanner.nextLine(), dtf);
        }
        systemFacade.setFilter(author, title, text, stamp);
    }

    private void removeMessages() {
        setUserFilter();

        System.out.println("These are messages to be removed:");
        systemFacade.showSelected(false, System.out);

        System.out.println("Do You really want to remove them? (Y/N)");
        String decision = scanner.nextLine();
        if (decision.contains("y") || decision.contains("Y")){
            if (systemFacade.removedSelected()) {
                System.out.println("Message(s) removed with success");
            }
            else {
                System.out.println("Something went wrong!");
            }
        }
    }

    private void filterMessages() {
        setUserFilter();

        System.out.print("Do You want simple or full format? (S/F): ");
        String format = scanner.nextLine();
        if ((format.contains("s")) || (format.contains("S"))) {
            systemFacade.showSelected(false, System.out);
        }
        else if ((format.contains("f")) || (format.contains("F"))) {
            systemFacade.showSelected(true, System.out);
        }
        else {
            System.out.println("Please try again!");
        }
    }

}
