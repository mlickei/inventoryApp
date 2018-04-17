package matthew.inventoryapp.intent;

import android.content.Context;
import android.content.Intent;

import matthew.inventoryapp.activity.AddItemsActivity;

/**
 * Created by Matthew on 4/16/2018.
 */

public class AddItemsActivityIntent {

    public static Intent createAddItemsActivity(Context context) {
        return new Intent(context, AddItemsActivity.class);
    }
}
