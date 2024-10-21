package com.example.store.main_activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.store.R;
import com.example.store.data.Shop;

import java.util.List;

public class ShopRecyclerViewAdapter extends RecyclerView.Adapter<ShopRecyclerViewAdapter.ShopHolder> {

    private final MainActivityViewModel model;
    private List<Shop> list;

    public ShopRecyclerViewAdapter(MainActivityViewModel model, List<Shop> list) {
        this.model = model;
        this.list = list;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        model.getListMutableLiveData().observeForever(this::reInit);
    }


    public void reInit(List<Shop> newItems) {
        if (list == null || list.isEmpty()) {
            list = newItems;
            notifyDataSetChanged();
            return;
        }
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new ShopsDiffUtils(list, newItems));
        list = newItems;
        diffResult.dispatchUpdatesTo(this);
    }

    @NonNull
    @Override
    public ShopHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_item, parent, false);
        return new ShopHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ShopHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView address;

        private final ImageView edit;
        private final ImageView remove;

        public ShopHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address);
            edit = itemView.findViewById(R.id.edit_icon);
            remove = itemView.findViewById(R.id.trash_icon);
        }

        public void bind(Shop item) {
            title.setText(item.getName());
            address.setText(item.getAddress());
            remove.setOnClickListener(v -> {
                Shop tmp=list.get(getAdapterPosition());
                model.onRemoveClicked(tmp);
            });

            edit.setOnClickListener(v -> {
                Shop tmp=list.get(getAdapterPosition());
                model.onEditClicked(tmp);
            });
        }


    }
}
