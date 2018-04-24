package matthew.inventoryapp.intent;

import android.content.Context;
import android.content.Intent;

import matthew.inventoryapp.activity.OrderManagement;

/**
 * Created by Matthew on 4/23/2018.
 */

public class ManageOrdersIntent {

    public static Intent createOrderManagementActivity(Context context) {
        return new Intent(context, OrderManagement.class);
    }
}
