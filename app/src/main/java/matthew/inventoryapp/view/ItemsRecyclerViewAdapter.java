package matthew.inventoryapp.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import matthew.inventoryapp.R;
import matthew.inventoryapp.intent.EditItemViewIntent;
import matthew.inventoryapp.item.Item;

/**
 * Created by Matthew on 4/9/2018.
 */

public class ItemsRecyclerViewAdapter extends RecyclerView.Adapter<ItemsRecyclerViewAdapter.ViewHolder> {

    private List<Item> items;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameView;
        public TextView searchIdView;
        public TextView sellPriceView;
        public Button editButton;

        public ViewHolder(View view) {
            super(view);

            nameView = itemView.findViewById(R.id.nameView);
            searchIdView = itemView.findViewById(R.id.searchIdView);
            sellPriceView = itemView.findViewById(R.id.sellPriceView);
            editButton = itemView.findViewById(R.id.editItemButton);

            view.setClickable(true);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO open item view
                }
            });
        }
    }

    public ItemsRecyclerViewAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_list_view, parent, false);
        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Item item = items.get(position);

        holder.nameView.setText(item.getName());
        holder.searchIdView.setText("#" + item.getSearchId());
        holder.sellPriceView.setText("$" + item.getSellPrice());
        holder.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(EditItemViewIntent.createEditItemViewIntent(context, item.getId()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
