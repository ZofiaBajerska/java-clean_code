import facade.StorageFacade;

import java.util.Scanner;

public class Application {

    private StorageFacade systemFacade;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        systemFacade = StorageFacade.getInstance();
        do {
            systemFacade.printMenu();
        } while (systemFacade.execute());
    }
}
