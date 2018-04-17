package matthew.inventoryapp.activity

import android.arch.lifecycle.Observer
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
import matthew.inventoryapp.item.ItemsViewModel

class EditItemView : AppCompatActivity() {

    private var intentType: String = ""
    lateinit var itemsViewModel: ItemsViewModel
    lateinit var item: Item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_item_view)
        setSupportActionBar(toolbar)

        itemsViewModel = ViewModelProviders.of(this).get(ItemsViewModel::class.java)

        intentType = intent.extras[EditItemViewIntent.INTENT_TYPE] as String
        val itemId: Any? = intent.extras[EditItemViewIntent.ITEM_ID]

        val editItemScroll = findViewById<View>(R.id.editItemScroll)

        if(itemId != null) {
            itemsViewModel.items.observe(this, Observer { items ->
                if(items!!.size > 0) {
                    var itemsFound: List<Item> = items.filter { item -> item.id == itemId }
                    if(itemsFound.size > 0) {
                        var itemFound:Item = itemsFound.get(0)
                            item = itemFound
                            setViewValuesFromItem(editItemScroll, item)
                    } else {
                        //Do nothing, we're leaving this view anyways
                    }
                    setupButtonEvents(intentType, editItemScroll)
                }
            })
        } else {
            setupButtonEvents(intentType, editItemScroll)
        }

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
                itemsViewModel.deleteItems(item)
                startActivity(AddItemsActivityIntent.createAddItemsActivity(this))
            }
        }

        if(intentType == EditItemViewIntent.NEW_ITEM) {
            saveBtn.text = "Create"
            saveBtn.setOnClickListener {
                val item:Item = getItemValuesFromView(editItemView, null)
                itemsViewModel.insertItems(item)
                startActivity(AddItemsActivityIntent.createAddItemsActivity(this))
            }
        } else {
            saveBtn.setOnClickListener {
                val item:Item = getItemValuesFromView(editItemView, item)
                itemsViewModel.updateItems(item)
                startActivity(AddItemsActivityIntent.createAddItemsActivity(this))
            }
        }
    }

    private fun setViewValuesFromItem(view:View, item:Item) {
        view.findViewById<EditText>(R.id.searchIdInput).setText(item.searchId)
        view.findViewById<EditText>(R.id.nameInpute).setText(item.name)
        view.findViewById<EditText>(R.id.sellPriceInput).setText(item.sellPrice.toString())
    }

    private fun getItemValuesFromView(view:View, item:Item?):Item {
        //If item null, make new one
        var updateItem:Item = item?:Item()

        updateItem.searchId = view.findViewById<EditText>(R.id.searchIdInput).text.toString()
        updateItem.name = view.findViewById<EditText>(R.id.nameInpute).text.toString()
        updateItem.sellPrice = view.findViewById<EditText>(R.id.sellPriceInput).text.toString().toDouble()
        //TODO pull bottom dollar if not firm

        return updateItem
    }

}
