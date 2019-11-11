package input;

import java.util.function.Predicate;

public interface Validator<T> extends Predicate<String> {
    T get();
}
