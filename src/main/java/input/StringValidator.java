package input;

public class StringValidator implements Validator<String> {
    private String value;

    @Override
    public boolean test(String s) {
        value = s;
        return !s.isEmpty();
    }

    @Override
    public String get() {
        return value;
    }
}
