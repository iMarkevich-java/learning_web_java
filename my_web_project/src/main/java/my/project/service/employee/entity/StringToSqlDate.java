package my.project.service.employee.entity;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StringToSqlDate {

    public StringToSqlDate() {
    }

    public Date parse(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date sqlDate = null;
        try {
            java.util.Date utilDate = format.parse(date);
            sqlDate = new Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sqlDate;
    }
}
