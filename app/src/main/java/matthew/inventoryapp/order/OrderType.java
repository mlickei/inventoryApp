package matthew.inventoryapp.order;

import android.arch.persistence.room.Entity;

/**
 * Created by Matthew on 4/8/2018.
 */
@Entity(tableName = "order_type")
public enum OrderType {
    BUY("Buy"), SELL("Sell");

    private String name;

    private OrderType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
