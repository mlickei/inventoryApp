package matthew.inventoryapp.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import matthew.inventoryapp.order.Order;

/**
 * Created by Matthew on 4/9/2018.
 */
@Dao
public interface OrderDAO {

    @Query("SELECT * FROM `order`")
    LiveData<List<Order>> getAllOrders();

    @Insert
    void insertOrders(Order... orders);

    @Update
    void updateOrders(Order... orders);

    @Delete
    void deleteOrders(Order... orders);

}
