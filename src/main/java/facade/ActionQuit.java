package facade;

public class ActionQuit implements UserAction {
    @Override
    public String getInfo() {
        return "Quit";
    }

    @Override
    public void execute() {
        System.out.println("Good bay!");
    }
}
