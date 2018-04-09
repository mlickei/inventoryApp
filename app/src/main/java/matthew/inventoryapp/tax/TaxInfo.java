package matthew.inventoryapp.tax;

import android.arch.persistence.room.Entity;

/**
 * Created by Matthew on 4/8/2018.
 */
@Entity(tableName = "tax_info")
public class TaxInfo {

    private long id;

    private double rate;

    private String state;

}
