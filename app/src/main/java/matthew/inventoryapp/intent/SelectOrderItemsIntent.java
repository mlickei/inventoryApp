package matthew.inventoryapp.intent;

import android.content.Context;
import android.content.Intent;

import matthew.inventoryapp.activity.SelectOrderItems;

/**
 * Created by Matthew on 5/7/2018.
 */

public class SelectOrderItemsIntent {
    public static Intent createOrderManagementActivity(Context context) {
        return new Intent(context, SelectOrderItems.class);
    }
}
