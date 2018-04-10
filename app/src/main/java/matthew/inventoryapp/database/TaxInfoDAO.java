package matthew.inventoryapp.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import matthew.inventoryapp.tax.TaxInfo;

/**
 * Created by Matthew on 4/9/2018.
 */
@Dao
public interface TaxInfoDAO {

    @Query("SELECT * FROM tax_info")
    LiveData<List<TaxInfo>> getAllTaxInfos();

    @Insert
    void insertTaxInfos(TaxInfo... taxInfo);

    @Update
    void updateTaxInfos(TaxInfo... taxInfo);

    @Delete
    void deleteTaxInfos(TaxInfo... taxInfo);

}
