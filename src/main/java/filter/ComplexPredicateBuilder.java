package filter;

import java.util.Date;

public class ComplexPredicateBuilder {
    private ComplexPredicate filter = new ComplexPredicate();

    public ComplexPredicateBuilder withTitle (final String title) {
        filter.addPredicate(new ByTitlePredicate(title));
        return this;
    }

    public ComplexPredicateBuilder withAuthor (final String author) {
        filter.addPredicate(new ByAuthorPredicate(author));
        return this;
    }

    public ComplexPredicateBuilder withText (final String text) {
        filter.addPredicate(new ByTextPredicate(text));
        return this;
    }

    public ComplexPredicateBuilder withDate (final Date date) {
        filter.addPredicate(new ByDatePredicate(date));
        return this;
    }

    public ComplexPredicate build(){
        return filter;
    }
}
