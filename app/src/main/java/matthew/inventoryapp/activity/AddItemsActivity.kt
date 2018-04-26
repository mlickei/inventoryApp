package matthew.inventoryapp.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.activity_add_items.*
import matthew.inventoryapp.R
import matthew.inventoryapp.intent.EditItemViewIntent
import matthew.inventoryapp.item.Item
import matthew.inventoryapp.item.ItemsViewModel
import matthew.inventoryapp.view.ItemsRecyclerViewAdapter

class AddItemsActivity : BaseActivity() {

    var items: ArrayList<Item> = ArrayList();
    lateinit var itemsRecyclerView: RecyclerView
    lateinit var itemsRecyclerViewAdapter: RecyclerView.Adapter<ItemsRecyclerViewAdapter.ViewHolder>
    lateinit var itemsRecyclerViewLayoutManager: RecyclerView.LayoutManager
    lateinit var itemsViewModel: ItemsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_items)
        setSupportActionBar(toolbar)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        addItem.setOnClickListener { view ->
            startActivity(EditItemViewIntent.createNewEditItemViewIntent(this))
        }

        //Get Listing View Content Container
        var listingViewContent: View = findViewById(R.id.itemsInclude)

        //TODO hook into the content container search crap

        //Get the Items List Recycler setup
        itemsRecyclerViewLayoutManager = LinearLayoutManager(this)
        itemsRecyclerViewAdapter = ItemsRecyclerViewAdapter(this, items)

        itemsRecyclerView = listingViewContent.findViewById(R.id.itemsList)
        itemsRecyclerView.layoutManager = itemsRecyclerViewLayoutManager
        itemsRecyclerView.adapter = itemsRecyclerViewAdapter

        itemsViewModel = ViewModelProviders.of(this).get(ItemsViewModel::class.java)
        itemsViewModel.items.observe(this, Observer { items ->
            this.items.clear()
            if (items != null) {
                this.items.addAll(items)
            }

            updateItemsListView()
        })
    }

    fun updateItemsListView() {
       itemsRecyclerViewAdapter.notifyDataSetChanged()
    }
}
