package matthew.inventoryapp.activity

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.*

import android.widget.FrameLayout
import matthew.inventoryapp.R
import matthew.inventoryapp.intent.AddItemsActivityIntent
import matthew.inventoryapp.intent.ManageOrdersIntent


/**
 * Created by Matthew on 4/25/2018.
 */
open class BaseActivity : AppCompatActivity(), MenuItem.OnMenuItemClickListener  {
    lateinit var drawer_layout : DrawerLayout
    lateinit var nav_view : NavigationView
    lateinit var toggle : ActionBarDrawerToggle
    lateinit var frame_view : FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_navigation_drawer)

        frame_view = findViewById(R.id.view_frame)
        drawer_layout = findViewById(R.id.main_drawer_layout)
        nav_view = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(
                this, drawer_layout, 0, 0)
        drawer_layout.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        var navMenu: Menu = nav_view.menu
        for(idx in 0 until navMenu.size()) {
            navMenu.getItem(idx).setOnMenuItemClickListener(this);
        }

    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun setContentView(layoutResID: Int) {
        if (frame_view != null) {
            val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val lp = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT)
            val stubView = inflater.inflate(layoutResID, frame_view, false)
            frame_view.addView(stubView, lp)
        }
    }

    override fun setContentView(view: View) {
        if (frame_view != null) {
            val lp = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT)
            frame_view.addView(view, lp)
        }
    }

    override fun setContentView(view: View, params: ViewGroup.LayoutParams) {
        if (frame_view != null) {
            frame_view.addView(view, params)
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
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
        if(toggle.onOptionsItemSelected(item)) {
            return true
        }

        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onMenuItemClick(item: MenuItem): Boolean {
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
        return false
    }
}