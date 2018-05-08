package matthew.inventoryapp.order;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;

import java.util.List;

import matthew.inventoryapp.database.AppDatabase;

/**
 * Created by Matthew on 4/9/2018.
 */

public class OrderItemsViewModel extends AndroidViewModel {

    private LiveData<List<OrderItem>> orderItems;
    private AppDatabase appDatabase;

    public OrderItemsViewModel(Application application) {
        super(application);

        appDatabase = Room.databaseBuilder(this.getApplication().getApplicationContext(), AppDatabase.class, AppDatabase.DATABASE_NAME).build();
        orderItems = appDatabase.orderItemsDAO().getAllOrderItems();
    }

    public LiveData<List<OrderItem>> getItems() {
        return orderItems;
    }

    public void insertOrderItems(OrderItem... orderItems) {
        new AddAsyncTask(appDatabase).execute(orderItems);
    }

    private static class AddAsyncTask extends AsyncTask<OrderItem, Void, Void> {

        private AppDatabase appDatabase;

        AddAsyncTask(AppDatabase appDatabase) {
            this.appDatabase = appDatabase;
        }

        @Override
        protected Void doInBackground(OrderItem... orderItems) {
            appDatabase.orderItemsDAO().insertOrderItems(orderItems);
            return null;
        }
    }

    public void updateOrderItems(OrderItem... orderItems) {
        new UpdateAsyncTask(appDatabase).execute(orderItems);
    }

    private static class UpdateAsyncTask extends AsyncTask<OrderItem, Void, Void> {

        private AppDatabase appDatabase;

        UpdateAsyncTask(AppDatabase appDatabase) {
            this.appDatabase = appDatabase;
        }

        @Override
        protected Void doInBackground(OrderItem... orderItems) {
            appDatabase.orderItemsDAO().updateOrderItems(orderItems);
            return null;
        }
    }

    public void deleteOrderItems(OrderItem... orderItems) {
        new DeleteAsyncTask(appDatabase).execute(orderItems);
    }

    private static class DeleteAsyncTask extends AsyncTask<OrderItem, Void, Void> {

        private AppDatabase appDatabase;

        DeleteAsyncTask(AppDatabase appDatabase) {
            this.appDatabase = appDatabase;
        }

        @Override
        protected Void doInBackground(OrderItem... orderItems) {
            appDatabase.orderItemsDAO().deleteOrderItems(orderItems);
            return null;
        }
    }
}
