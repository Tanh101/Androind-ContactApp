package com.example.contactapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.example.contactapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<Contact> contactList;
    private ContactAdapter contactAdapter;
    private AppDatabase appDatabase;
    private ContactDAO contactDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.rvContacts.setLayoutManager(new LinearLayoutManager(this));
        contactList = new ArrayList<Contact>();
        contactAdapter = new ContactAdapter(contactList);
        binding.rvContacts.setAdapter(contactAdapter);

        contactList.add(new Contact("Nguyen Van A", "0329503172", "lyvantanh101@gmail.com"));
        contactList.add(new Contact("Nguyen Van B", "0329503173", "lyvantanh102@gmail.com"));
        contactList.add(new Contact("Nguyen Van C", "0329503174", "lyvantanh103@gmail.com"));



        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                appDatabase = AppDatabase.getInstance(getApplicationContext());
                contactDao = appDatabase.contactDao();
                contactDao.insert(new Contact("Nguyen Van A", "0329444333", "lyvantanh101@gmail.com"));
            }
        });
        contactAdapter.notifyDataSetChanged();



    }
}