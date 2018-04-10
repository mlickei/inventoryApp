package matthew.inventoryapp.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import matthew.inventoryapp.order.OrderItems;

/**
 * Created by Matthew on 4/9/2018.
 */
@Dao
public interface OrderItemsDAO {

    @Query("SELECT * FROM order_items")
    LiveData<List<OrderItems>> getAllOrderItems();

    @Insert
    void insertOrderItems(OrderItems... orderItems);

    @Update
    void updateOrderItems(OrderItems... orderItems);

    @Delete
    void deleteOrderItems(OrderItems... orderItem);

}
