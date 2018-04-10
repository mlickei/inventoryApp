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

public class OrderViewModel extends AndroidViewModel {

    private LiveData<List<Order>> orders;
    private AppDatabase appDatabase;

    public OrderViewModel(Application application) {
        super(application);

        appDatabase = Room.databaseBuilder(this.getApplication().getApplicationContext(), AppDatabase.class, AppDatabase.DATABASE_NAME).build();
        orders = appDatabase.orderDAO().getAllOrders();
    }

    public LiveData<List<Order>> getOrders() {
        return orders;
    }

    public void insertOrders(Order... orders) {
        new AddAsyncTask(appDatabase).execute(orders);
    }

    private static class AddAsyncTask extends AsyncTask<Order, Void, Void> {

        private AppDatabase appDatabase;

        AddAsyncTask(AppDatabase appDatabase) {
            this.appDatabase = appDatabase;
        }

        @Override
        protected Void doInBackground(Order... orders) {
            appDatabase.orderDAO().insertOrders(orders);
            return null;
        }
    }

    public void updateOrders(Order... orders) {
        new UpdateAsyncTask(appDatabase).execute(orders);
    }

    private static class UpdateAsyncTask extends AsyncTask<Order, Void, Void> {

        private AppDatabase appDatabase;

        UpdateAsyncTask(AppDatabase appDatabase) {
            this.appDatabase = appDatabase;
        }

        @Override
        protected Void doInBackground(Order... orders) {
            appDatabase.orderDAO().updateOrders(orders);
            return null;
        }
    }

    public void deleteOrders(Order... orders) {
        new DeleteAsyncTask(appDatabase).execute(orders);
    }

    private static class DeleteAsyncTask extends AsyncTask<Order, Void, Void> {

        private AppDatabase appDatabase;

        DeleteAsyncTask(AppDatabase appDatabase) {
            this.appDatabase = appDatabase;
        }

        @Override
        protected Void doInBackground(Order... orders) {
            appDatabase.orderDAO().deleteOrders(orders);
            return null;
        }
    }
}
