package matthew.inventoryapp.item;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Items are things that can be sold.
 *
 * Created by Matthew on 4/8/2018.
 */
@Entity(tableName = "item")
public class Item {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name="search_id")
    private String searchId;

    @ColumnInfo
    private String name;

    @ColumnInfo(name="sell_price")
    private double sellPrice;

    @ColumnInfo(name="bottom_dollar")
    private double bottomDollar;

    @ColumnInfo(name="is_firm_price")
    private boolean isFirmPrice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getBottomDollar() {
        return bottomDollar;
    }

    public void setBottomDollar(double bottomDollar) {
        this.bottomDollar = bottomDollar;
    }

    public boolean isFirmPrice() {
        return isFirmPrice;
    }

    public void setFirmPrice(boolean firmPrice) {
        isFirmPrice = firmPrice;
    }
}
