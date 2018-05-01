package matthew.inventoryapp.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.activity_order_management.*
import matthew.inventoryapp.R
import matthew.inventoryapp.order.Order
import matthew.inventoryapp.order.OrderViewModel
import matthew.inventoryapp.view.OrdersRecylerViewAdapter
import org.jetbrains.annotations.Nullable

class OrderManagement : BaseActivity() {

    var orders: ArrayList<Order> = ArrayList()
    lateinit var ordersRecyclerViewAdapter: RecyclerView.Adapter<OrdersRecylerViewAdapter.ViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_management)
        setSupportActionBar(toolbar)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        addOrder.setOnClickListener { view ->
            //TODO
        }

        setupRecyclerView()
        setupOrdersViewModel()
    }

    private fun setupRecyclerView() {
        //Get Listing View Content Container
        var listingViewContent: View = findViewById(R.id.ordersInclude)

        var ordersRecyclerViewLayoutManager = LinearLayoutManager(this)
        ordersRecyclerViewAdapter = OrdersRecylerViewAdapter(this.orders, this)

        var ordersRecyclerView: RecyclerView = listingViewContent.findViewById(R.id.ordersList)
        ordersRecyclerView.layoutManager = ordersRecyclerViewLayoutManager
        ordersRecyclerView.adapter = ordersRecyclerViewAdapter
    }

    private fun setupOrdersViewModel() {
        var ordersViewModel: OrderViewModel = ViewModelProviders.of(this).get(OrderViewModel::class.java)
        ordersViewModel.orders.observe(this, Observer { orders ->
            handleOrdersListUpdate(orders as List<Order>)
        })
    }

    private fun handleOrdersListUpdate(@Nullable orders:List<Order>) {
        this.orders.clear()

        if(orders != null) {
            this.orders.addAll(orders)
        }

        updateOrdersListView()
    }

    private fun updateOrdersListView() {
        ordersRecyclerViewAdapter.notifyDataSetChanged()
    }
}
