package matthew.inventoryapp.database;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by Matthew on 4/9/2018.
 */

public class DateTypeConverter {
    @TypeConverter
    public static Date timestampToDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
