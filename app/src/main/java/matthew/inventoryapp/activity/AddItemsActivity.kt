package matthew.inventoryapp.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_add_items.*
import matthew.inventoryapp.R
import matthew.inventoryapp.intent.EditItemViewIntent
import matthew.inventoryapp.item.Item
import matthew.inventoryapp.item.ItemsViewModel
import matthew.inventoryapp.view.ItemsRecyclerViewAdapter

class AddItemsActivity : AppCompatActivity() {

    var items: ArrayList<Item> = ArrayList();
    lateinit var itemsRecyclerView: RecyclerView
    lateinit var itemsRecyclerViewAdapter: RecyclerView.Adapter<ItemsRecyclerViewAdapter.ViewHolder>
    lateinit var itemsRecyclerViewLayoutManager: RecyclerView.LayoutManager
    lateinit var itemsViewModel: ItemsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_items)
        setSupportActionBar(toolbar)

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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_add_items, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun updateItemsListView() {
       itemsRecyclerViewAdapter.notifyDataSetChanged()
    }
}
