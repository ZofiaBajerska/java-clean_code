package facade;

import java.util.Scanner;

public class ActionQuit implements UserAction {

    private Scanner scanner;
    public ActionQuit(Scanner scanner){
        this.scanner = scanner;
    }
    @Override
    public String getInfo() {
        return "Quit";
    }

    @Override
    public boolean execute() {
        System.out.print("Do You want to exit? (Y/N): ");
        String format = scanner.nextLine();
        if ((format.contains("y")) || (format.contains("Y"))){
            System.out.println("Good bay!");
            return false;
        }
        return true;
    }
}
