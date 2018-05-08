package matthew.inventoryapp.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import matthew.inventoryapp.R

class SelectOrderItems : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_order_items)
        setupDoneButton()
    }

    private fun setupDoneButton() {
        val doneButton: Button = findViewById(R.id.doneSelectingOrderItemsButton)
        doneButton.setOnClickListener({view ->
            finish()
        })
    }
}
