package matthew.inventoryapp.order;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Matthew on 4/9/2018.
 */
@Entity(tableName = "order_items")
public class OrderItems {

    @PrimaryKey
    private long id;

    @ColumnInfo(name = "order_id")
    private long orderId;

    @ColumnInfo(name = "item_id")
    private long itemId;

}
