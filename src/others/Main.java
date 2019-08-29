package others;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time="1970-01-06 11:45:55";
        Date date = format.parse(time);
        System.out.println("Format To times:"+date.getTime());
        Date sqlDate = new java.sql.Date(date.getTime());
        System.out.println("Format To times:"+sqlDate);
    }
}
