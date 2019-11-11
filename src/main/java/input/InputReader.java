package input;

import java.util.Scanner;

public class InputReader<T> {
    private Validator<T> validator;

    public InputReader(Validator<T> validator){
        this.validator = validator;
    }

    public T getValue(String message, Scanner scanner){
        String line;
        do {
            System.out.println(message);
            line = scanner.nextLine();
        } while (!validator.test(line));
        return validator.get();
    }
}
