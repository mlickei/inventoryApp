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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
