package matthew.inventoryapp.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import kotlinx.android.synthetic.main.activity_edit_order_view.*
import matthew.inventoryapp.R
import matthew.inventoryapp.intent.SelectOrderItemsIntent

/**
 * Created by Matthew on 4/30/2018.
 */
class EditOrderView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_order_view)
        setSupportActionBar(toolbar)
        setupButtons()
    }

    private fun setupButtons() {
        setupAddButton()
        setupResetButton()
        setupFinalizeButton()
    }

    private fun setupAddButton() {
        val addButton:Button = findViewById(R.id.addOrderItemButton)
        addButton.setOnClickListener({view ->
            startActivity(SelectOrderItemsIntent.createOrderManagementActivity(this))
        })
    }

    private fun setupResetButton() {
        val resetButton:Button = findViewById(R.id.resetOrderItemsButton)
        resetButton.setOnClickListener({view ->
            //TODO delete all the order items
        })
    }

    private fun setupFinalizeButton() {
        val finalizeButton:Button = findViewById(R.id.finalizeOrderButton)
        finalizeButton.setOnClickListener({view ->
            //TODO save the order object
        })
    }
}