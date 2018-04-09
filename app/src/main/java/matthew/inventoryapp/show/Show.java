package matthew.inventoryapp.show;

import android.arch.persistence.room.Entity;

import java.util.Date;

/**
 * Created by Matthew on 4/8/2018.
 */
@Entity(tableName = "show")
public class Show {

    private long id;

    private String name;

    private Date startdate;

    private Date endDate;

}
