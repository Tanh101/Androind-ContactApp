package com.example.contactapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    public ContactAdapter(ArrayList<String> contactList) {
        this.contactList = contactList;
    }

    private ArrayList<String> contactList;



    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_row_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {
        holder.tvName.setText(contactList.get(position));
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;

        public ViewHolder(View view) {
            super(view);
            tvName = (TextView) view.findViewById(R.id.tv_name);
        }

    }
}
