package matthew.inventoryapp.item;

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

public class ItemViewModel extends AndroidViewModel {

    private LiveData<List<Item>> items;
    private AppDatabase appDatabase;

    public ItemViewModel(Application application) {
        super(application);

        appDatabase = Room.databaseBuilder(this.getApplication().getApplicationContext(), AppDatabase.class, AppDatabase.DATABASE_NAME).build();
        items = appDatabase.itemDAO().getAllItems();
    }

    public LiveData<List<Item>> getItems() {
        return items;
    }

    public void insertItems(Item... items) {
        new AddAsyncTask(appDatabase).execute(items);
    }

    private static class AddAsyncTask extends AsyncTask<Item, Void, Void> {

        private AppDatabase appDatabase;

        AddAsyncTask(AppDatabase appDatabase) {
            this.appDatabase = appDatabase;
        }

        @Override
        protected Void doInBackground(Item... items) {
            appDatabase.itemDAO().insertItems(items);
            return null;
        }
    }

    public void updateItems(Item... items) {
        new UpdateAsyncTask(appDatabase).execute(items);
    }

    private static class UpdateAsyncTask extends AsyncTask<Item, Void, Void> {

        private AppDatabase appDatabase;

        UpdateAsyncTask(AppDatabase appDatabase) {
            this.appDatabase = appDatabase;
        }

        @Override
        protected Void doInBackground(Item... items) {
            appDatabase.itemDAO().updateItems(items);
            return null;
        }
    }

    public void deleteItems(Item... items) {
        new DeleteAsyncTask(appDatabase).execute(items);
    }

    private static class DeleteAsyncTask extends AsyncTask<Item, Void, Void> {

        private AppDatabase appDatabase;

        DeleteAsyncTask(AppDatabase appDatabase) {
            this.appDatabase = appDatabase;
        }

        @Override
        protected Void doInBackground(Item... items) {
            appDatabase.itemDAO().deleteItems(items);
            return null;
        }
    }
}
