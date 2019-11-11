package filter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ComplexFilterBuilder {
    private ComplexPredicate filter = new ComplexPredicate();

    public ComplexFilterBuilder withTitle (final String title) {
        filter.addPredicate(new ByTitlePredicate(title));
        return this;
    }

    public ComplexFilterBuilder withAuthor (final String author) {
        filter.addPredicate(new ByAuthorPredicate(author));
        return this;
    }

    public ComplexFilterBuilder withText (final String text) {
        filter.addPredicate(new ByTextPredicate(text));
        return this;
    }

    public ComplexFilterBuilder withDate (final Date date) {
        filter.addPredicate(new ByDatePredicate(date));
        return this;
    }

    public ComplexPredicate build(){
        return filter;
    }
}
