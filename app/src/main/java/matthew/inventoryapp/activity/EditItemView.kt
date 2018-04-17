package matthew.inventoryapp.activity

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_edit_item_view.*
import matthew.inventoryapp.R
import matthew.inventoryapp.intent.AddItemsActivityIntent
import matthew.inventoryapp.intent.EditItemViewIntent
import matthew.inventoryapp.item.Item
import matthew.inventoryapp.item.ItemViewModel

class EditItemView : AppCompatActivity() {

    private var intentType: String = ""
    lateinit var itemViewModel: ItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_item_view)
        setSupportActionBar(toolbar)

        intentType = intent.extras[EditItemViewIntent.INTENT_TYPE] as String
        itemViewModel = ViewModelProviders.of(this).get(ItemViewModel::class.java)

        val editItemScroll = findViewById<View>(R.id.editItemScroll)
        setupButtonEvents(intentType, editItemScroll)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun setupButtonEvents(intentType:String, editItemView:View) {
        var saveBtn = editItemView.findViewById<Button>(R.id.saveButton)
        var discardButton = editItemView.findViewById<Button>(R.id.discardButton)

        //Delete button
        if(intentType == EditItemViewIntent.NEW_ITEM) {
            discardButton.setOnClickListener { startActivity(AddItemsActivityIntent.createAddItemsActivity(this)) }
        } else {
            discardButton.text = "Delete"
            discardButton.setOnClickListener {
                //TODO delete item
                startActivity(AddItemsActivityIntent.createAddItemsActivity(this))
            }
        }

        if(intentType == EditItemViewIntent.NEW_ITEM) {
            saveBtn.text = "Create"
            saveBtn.setOnClickListener {
                val item:Item = getItemValuesFromView(editItemView, null)
                itemViewModel.insertItems(item)
                startActivity(AddItemsActivityIntent.createAddItemsActivity(this))
            }
        } else {
            saveBtn.setOnClickListener {
                val item:Item = getItemValuesFromView(editItemView, null)
                itemViewModel.insertItems(item)
                startActivity(AddItemsActivityIntent.createAddItemsActivity(this))
            }
        }
    }

    fun getItemValuesFromView(view:View, item:Item?):Item {
        //If item null, make new one
        var updateItem:Item = item?:Item()

        updateItem.searchId = view.findViewById<EditText>(R.id.searchIdInput).text.toString()
        updateItem.name = view.findViewById<EditText>(R.id.nameInpute).text.toString()
        updateItem.sellPrice = view.findViewById<EditText>(R.id.sellPriceInput).text.toString().toDouble()
        //TODO pull bottom dollar if not firm

        return updateItem
    }

}
