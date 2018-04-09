package matthew.inventoryapp.tax;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Matthew on 4/8/2018.
 */
@Entity(tableName = "tax_info")
public class TaxInfo {

    @PrimaryKey
    private long id;

    @ColumnInfo
    private double rate;

    @ColumnInfo
    private String state;

}
