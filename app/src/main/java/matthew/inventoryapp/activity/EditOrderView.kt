package matthew.inventoryapp.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit_order_view.*
import matthew.inventoryapp.R

/**
 * Created by Matthew on 4/30/2018.
 */
class EditOrderView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_order_view)
        setSupportActionBar(toolbar)
    }
}