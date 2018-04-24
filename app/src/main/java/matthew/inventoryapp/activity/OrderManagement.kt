package matthew.inventoryapp.activity

import android.content.Context
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_navigation_drawer.*
import matthew.inventoryapp.R

import kotlinx.android.synthetic.main.activity_order_management.*
import matthew.inventoryapp.intent.AddItemsActivityIntent
import matthew.inventoryapp.intent.ManageOrdersIntent

class OrderManagement : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_management)
        setSupportActionBar(toolbar)

        addOrder.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val drawerActivityView = (getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(R.layout.activity_navigation_drawer, null, false)
        val drawerLayout = drawerActivityView.findViewById<DrawerLayout>(R.id.main_drawer_layout)
        val navView = drawerActivityView.findViewById<NavigationView>(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
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

}
