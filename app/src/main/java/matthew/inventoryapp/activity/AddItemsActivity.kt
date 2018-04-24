package matthew.inventoryapp.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_add_items.*
import kotlinx.android.synthetic.main.activity_navigation_drawer.*
import matthew.inventoryapp.R
import matthew.inventoryapp.intent.AddItemsActivityIntent
import matthew.inventoryapp.intent.EditItemViewIntent
import matthew.inventoryapp.intent.ManageOrdersIntent
import matthew.inventoryapp.item.Item
import matthew.inventoryapp.item.ItemsViewModel
import matthew.inventoryapp.view.ItemsRecyclerViewAdapter

class AddItemsActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var items: ArrayList<Item> = ArrayList();
    lateinit var itemsRecyclerView: RecyclerView
    lateinit var itemsRecyclerViewAdapter: RecyclerView.Adapter<ItemsRecyclerViewAdapter.ViewHolder>
    lateinit var itemsRecyclerViewLayoutManager: RecyclerView.LayoutManager
    lateinit var itemsViewModel: ItemsViewModel
    lateinit var drawerLayout: DrawerLayout

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

        val drawerActivityView = (getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(R.layout.activity_navigation_drawer, null, false)
        drawerLayout = drawerActivityView.findViewById<DrawerLayout>(R.id.main_drawer_layout)
        val navView = drawerActivityView.findViewById<NavigationView>(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.navigation_drawer, menu)
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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_orders -> {
                startActivity(ManageOrdersIntent.createOrderManagementActivity(this))
            }
            R.id.nav_items -> {
                startActivity(AddItemsActivityIntent.createAddItemsActivity(this))
            }
            R.id.nav_shows -> {

            }
            R.id.nav_tax -> {

            }
        }

        main_drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun updateItemsListView() {
       itemsRecyclerViewAdapter.notifyDataSetChanged()
    }
}
