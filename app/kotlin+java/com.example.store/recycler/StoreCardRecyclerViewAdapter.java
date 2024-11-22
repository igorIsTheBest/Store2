package com.example.store.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.store.R;
import com.example.store.data.room.StoreCardEntity;

import java.util.List;

public class StoreCardRecyclerViewAdapter extends RecyclerView.Adapter<StoreCardRecyclerViewAdapter.ViewHolder> {

    private List<StoreCardEntity> medicalCards;

    public StoreCardRecyclerViewAdapter(List<StoreCardEntity> storeCards) {
        this.storeCards = medicalCards;
    }

    public void updateList(List<StoreCardEntity> newList) {
        storeCards = newList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.store_card_recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MedicalCardEntity storeCard = storeCards.get(position);
        holder.nameTextView.setText("Назва: " + storeCard.storeName);  // Додаємо опис для наочності
        holder.emplTextView.setText("Співробітники: " + storeCard.empl);
        holder.addressTextView.setText("Адреса: " + storeCard.address);
    }

    @Override
    public int getItemCount() {
        return storeCards.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView emplTextView;
        public TextView addressTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.textViewName);
            emplTextView = itemView.findViewById(R.id.textViewempl);
            addressTextView = itemView.findViewById(R.id.textViewaddress);
        }
    }
}
