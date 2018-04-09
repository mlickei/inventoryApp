package matthew.inventoryapp.show;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by Matthew on 4/8/2018.
 */
@Entity(tableName = "show")
public class Show {

    @PrimaryKey
    private long id;

    @ColumnInfo
    private String name;

    @ColumnInfo(name = "start_date")
    private Date startdate;

    @ColumnInfo(name = "end_date")
    private Date endDate;

}
