package matthew.inventoryapp.show;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;

import java.util.List;

import matthew.inventoryapp.database.AppDatabase;
import matthew.inventoryapp.show.Show;

/**
 * Created by Matthew on 4/9/2018.
 */

public class ShowViewModel extends AndroidViewModel {

    private LiveData<List<Show>> shows;
    private AppDatabase appDatabase;

    public ShowViewModel(Application application) {
        super(application);

        appDatabase = Room.databaseBuilder(this.getApplication().getApplicationContext(), AppDatabase.class, AppDatabase.DATABASE_NAME).build();
        shows = appDatabase.showDAO().getAllShows();
    }

    public LiveData<List<Show>> getShows() {
        return shows;
    }

    public void insertShows(Show... shows) {
        new AddAsyncTask(appDatabase).execute(shows);
    }

    private static class AddAsyncTask extends AsyncTask<Show, Void, Void> {

        private AppDatabase appDatabase;

        AddAsyncTask(AppDatabase appDatabase) {
            this.appDatabase = appDatabase;
        }

        @Override
        protected Void doInBackground(Show... shows) {
            appDatabase.showDAO().insertShows(shows);
            return null;
        }
    }

    public void updateShows(Show... shows) {
        new UpdateAsyncTask(appDatabase).execute(shows);
    }

    private static class UpdateAsyncTask extends AsyncTask<Show, Void, Void> {

        private AppDatabase appDatabase;

        UpdateAsyncTask(AppDatabase appDatabase) {
            this.appDatabase = appDatabase;
        }

        @Override
        protected Void doInBackground(Show... shows) {
            appDatabase.showDAO().updateShows(shows);
            return null;
        }
    }

    public void deleteShows(Show... shows) {
        new DeleteAsyncTask(appDatabase).execute(shows);
    }

    private static class DeleteAsyncTask extends AsyncTask<Show, Void, Void> {

        private AppDatabase appDatabase;

        DeleteAsyncTask(AppDatabase appDatabase) {
            this.appDatabase = appDatabase;
        }

        @Override
        protected Void doInBackground(Show... shows) {
            appDatabase.showDAO().deleteShows(shows);
            return null;
        }
    }
}
