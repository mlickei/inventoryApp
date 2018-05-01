package matthew.inventoryapp.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import matthew.inventoryapp.R;
import matthew.inventoryapp.order.Order;

/**
 * Created by Matthew on 4/30/2018.
 */

public class OrdersRecylerViewAdapter extends RecyclerView.Adapter<OrdersRecylerViewAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView orderIdView;
        private TextView orderDateView;
        private TextView orderTotalView;
        private Button detailsButton;

        public ViewHolder(View view) {
            super(view);

            setOrderIdView((TextView) itemView.findViewById(R.id.order_id));
            setOrderDateView((TextView) itemView.findViewById(R.id.order_date));
            setOrderTotalView((TextView) itemView.findViewById(R.id.order_total));
            setDetailsButton((Button) itemView.findViewById(R.id.order_details_button));
        }

        public TextView getOrderIdView() {
            return orderIdView;
        }

        public void setOrderIdView(TextView orderIdView) {
            this.orderIdView = orderIdView;
        }

        public TextView getOrderDateView() {
            return orderDateView;
        }

        public void setOrderDateView(TextView orderDateView) {
            this.orderDateView = orderDateView;
        }

        public TextView getOrderTotalView() {
            return orderTotalView;
        }

        public void setOrderTotalView(TextView orderTotalView) {
            this.orderTotalView = orderTotalView;
        }

        public Button getDetailsButton() {
            return detailsButton;
        }

        public void setDetailsButton(Button detailsButton) {
            this.detailsButton = detailsButton;
        }
    }

    private List<Order> orders;
    private Context context;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

    public OrdersRecylerViewAdapter(List<Order> orders, Context context) {
        this.orders = orders;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.orders_list_view, parent, false);
        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Order order = orders.get(position);

        holder.getOrderIdView().setText("#" + order.getId());
        holder.getOrderDateView().setText(dateFormat.format(order.getDate()));
        holder.getOrderTotalView().setText("$" + order.getFinalPriceCharged());
//        holder.getDetailsButton().setOnClickListener((v) -> {
//            context.startActivity();
//        });
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }
}
