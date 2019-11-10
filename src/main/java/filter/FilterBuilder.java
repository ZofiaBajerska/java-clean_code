package filter;

import java.time.LocalDateTime;

public class FilterBuilder {
    private ByAnyPredicate filter = new ByAnyPredicate();

    public FilterBuilder withTitle (final String title) {
        filter.addPredicate(new ByTitlePredicate(title));
        return this;
    }

    public FilterBuilder withAuthor (final String author) {
        filter.addPredicate(new ByAuthorPredicate(author));
        return this;
    }

    public FilterBuilder withText (final String text) {
        filter.addPredicate(new ByTextPredicate(text));
        return this;
    }

    public FilterBuilder withDate (final LocalDateTime date) {
        filter.addPredicate(new ByDatePredicate(date));
        return this;
    }

    public ByAnyPredicate build(){
        return filter;
    }
}
