package matthew.inventoryapp.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import matthew.inventoryapp.show.Show;

/**
 * Created by Matthew on 4/9/2018.
 */
@Dao
public interface ShowDAO {

    @Query("SELECT * FROM show")
    LiveData<List<Show>> getAllShows();

    @Insert
    void insertShows(Show... shows);

    @Update
    void updateShows(Show... shows);

    @Delete
    void deleteShows(Show... show);

}
