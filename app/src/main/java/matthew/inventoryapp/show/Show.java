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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
