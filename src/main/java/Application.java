import facade.StorageFacade;

public class Application {

    private StorageFacade systemFacade;

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
