package matthew.inventoryapp.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import matthew.inventoryapp.order.OrderItem;

/**
 * Created by Matthew on 4/9/2018.
 */
@Dao
public interface OrderItemsDAO {

    @Query("SELECT * FROM order_item")
    LiveData<List<OrderItem>> getAllOrderItems();

    @Insert
    void insertOrderItems(OrderItem... orderItems);

    @Update
    void updateOrderItems(OrderItem... orderItems);

    @Delete
    void deleteOrderItems(OrderItem... orderItem);

}
