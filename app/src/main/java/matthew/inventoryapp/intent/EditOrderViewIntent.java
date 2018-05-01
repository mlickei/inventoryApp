package matthew.inventoryapp.intent;

import android.content.Context;
import android.content.Intent;

import matthew.inventoryapp.activity.EditOrderView;

/**
 * Created by Matthew on 4/30/2018.
 */

public class EditOrderViewIntent {
    public static String NEW_ORDER = "NEW_ORDER";
    public static String EDIT_ORDER = "EDIT_ORDER";
    public static String INTENT_TYPE = "INTENT_TYPE";
    public static String ORDER_ID = "ORDER_ID";

    public static Intent createNewEditOrderViewIntent(Context context) {
        return new Intent(context, EditOrderView.class).putExtra(INTENT_TYPE, NEW_ORDER);
    }

    public static Intent createEditOrderViewIntent(Context context, long itemId) {
        return new Intent(context, EditOrderView.class).putExtra(INTENT_TYPE, EDIT_ORDER).putExtra(ORDER_ID, itemId);
    }
}
