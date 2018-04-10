package matthew.inventoryapp.tax;

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

public class TaxInfoViewModel extends AndroidViewModel {

    private LiveData<List<TaxInfo>> taxInfos;
    private AppDatabase appDatabase;

    public TaxInfoViewModel(Application application) {
        super(application);

        appDatabase = Room.databaseBuilder(this.getApplication().getApplicationContext(), AppDatabase.class, AppDatabase.DATABASE_NAME).build();
        taxInfos = appDatabase.taxInfoDAO().getAllTaxInfos();
    }

    public LiveData<List<TaxInfo>> getTaxInfos() {
        return taxInfos;
    }

    public void insertTaxInfos(TaxInfo... taxInfos) {
        new AddAsyncTask(appDatabase).execute(taxInfos);
    }

    private static class AddAsyncTask extends AsyncTask<TaxInfo, Void, Void> {

        private AppDatabase appDatabase;

        AddAsyncTask(AppDatabase appDatabase) {
            this.appDatabase = appDatabase;
        }

        @Override
        protected Void doInBackground(TaxInfo... taxInfos) {
            appDatabase.taxInfoDAO().insertTaxInfos(taxInfos);
            return null;
        }
    }

    public void updateTaxInfos(TaxInfo... taxInfos) {
        new UpdateAsyncTask(appDatabase).execute(taxInfos);
    }

    private static class UpdateAsyncTask extends AsyncTask<TaxInfo, Void, Void> {

        private AppDatabase appDatabase;

        UpdateAsyncTask(AppDatabase appDatabase) {
            this.appDatabase = appDatabase;
        }

        @Override
        protected Void doInBackground(TaxInfo... taxInfos) {
            appDatabase.taxInfoDAO().updateTaxInfos(taxInfos);
            return null;
        }
    }

    public void deleteTaxInfos(TaxInfo... taxInfos) {
        new DeleteAsyncTask(appDatabase).execute(taxInfos);
    }

    private static class DeleteAsyncTask extends AsyncTask<TaxInfo, Void, Void> {

        private AppDatabase appDatabase;

        DeleteAsyncTask(AppDatabase appDatabase) {
            this.appDatabase = appDatabase;
        }

        @Override
        protected Void doInBackground(TaxInfo... taxInfos) {
            appDatabase.taxInfoDAO().deleteTaxInfos(taxInfos);
            return null;
        }
    }
}
