package matthew.inventoryapp.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import matthew.inventoryapp.item.Item;

/**
 * Created by Matthew on 4/9/2018.
 */
@Dao
public interface ItemDAO {

    @Query("SELECT * FROM item")
    LiveData<List<Item>> getAllItems();

    @Insert
    void insertItems(Item... items);

    @Update
    void updateItems(Item... items);

    @Delete
    void deleteItems(Item... items);

}
