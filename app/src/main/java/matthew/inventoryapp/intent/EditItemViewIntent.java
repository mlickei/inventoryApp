package matthew.inventoryapp.intent;

import android.content.Context;
import android.content.Intent;

import matthew.inventoryapp.activity.EditItemView;

/**
 * Created by Matthew on 4/16/2018.
 */

public class EditItemViewIntent {

    public static String NEW_ITEM = "NEW_ITEM";
    public static String EDIT_ITEM = "EDIT_ITEM";
    public static String INTENT_TYPE = "INTENT_TYPE";
    public static String ITEM_ID = "ITEM_ID";

    public static Intent createNewEditItemViewIntent(Context context) {
        return new Intent(context, EditItemView.class).putExtra(INTENT_TYPE, NEW_ITEM);
    }

    public static Intent createEditItemViewIntent(Context context, long itemId) {
        return new Intent(context, EditItemView.class).putExtra(INTENT_TYPE, EDIT_ITEM).putExtra(ITEM_ID, itemId);
    }
}
