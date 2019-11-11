package input;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class DateTimeValidator implements Validator<Date> {
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
    private final Logger log = Logger.getLogger(DateTimeValidator.class.getName());
    private Date date = new Date();

    @Override
    public boolean test(String s) {

        try{
            date = simpleDateFormat.parse(s);
            return true;
        }
        catch (ParseException e){
            log.warning("Wrong date format");
            log.warning(e.getMessage());
        }
        return false;
    }

    @Override
    public Date get() {
        return date;
    }
}
