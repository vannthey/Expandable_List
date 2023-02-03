package com.example.expanablelist;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.expanablelist.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<Model> modelList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getSupportActionBar() != null;
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        modelList = new ArrayList<>();
        modelList.add(new Model("What is Computer", "A computer is a machine that can be programmed to carry out sequences of arithmetic or logical operations automatically."));
        modelList.add(new Model("What is Computer", "A computer is a machine that can be programmed to carry out sequences of arithmetic or logical operations automatically."));
        modelList.add(new Model("What is Computer", "A computer is a machine that can be programmed to carry out sequences of arithmetic or logical operations automatically."));

        adapter = new Adapter(this, modelList);
        binding.ExpandableList.setAdapter(adapter);
    }
}