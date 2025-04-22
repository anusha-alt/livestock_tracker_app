package com.example.at_lab_project;
import android.view.View;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder> {

    public interface OnServiceClickListener {
        void onServiceClick(ServiceItem item);
    }

    private List<ServiceItem> serviceList;
    private OnServiceClickListener listener;

    public ServiceAdapter(List<ServiceItem> serviceList, OnServiceClickListener listener) {
        this.serviceList = serviceList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_service, parent, false);
        return new ServiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceViewHolder holder, int position) {
        ServiceItem item = serviceList.get(position);
        holder.name.setText(item.name);
        holder.icon.setImageResource(item.iconRes);
        holder.itemView.setOnClickListener(v -> listener.onServiceClick(item));
    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }

    public static class ServiceViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView name;

        public ServiceViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.serviceIcon);
            name = itemView.findViewById(R.id.serviceName);
        }
    }
}

