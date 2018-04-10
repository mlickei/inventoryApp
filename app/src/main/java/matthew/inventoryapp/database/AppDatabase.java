package matthew.inventoryapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import matthew.inventoryapp.item.Item;
import matthew.inventoryapp.order.Order;
import matthew.inventoryapp.order.OrderItems;
import matthew.inventoryapp.show.Show;
import matthew.inventoryapp.tax.TaxInfo;

/**
 * Created by Matthew on 4/9/2018.
 */
@Database(entities = {Item.class, Order.class, OrderItems.class, Show.class, TaxInfo.class}, version = 0)
@TypeConverters({DateTypeConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract ItemDAO itemDAO();

    public abstract OrderDAO orderDAO();

    public abstract OrderItemsDAO orderItemsDAO();

    public abstract ShowDAO showDAO();

    public abstract TaxInfoDAO taxInfoDAO();

    public static final String DATABASE_NAME = "inventory_app";

}
