package com.example.recycleviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.recycleviewdemo.databinding.ActivityMainBinding;
import com.example.recycleviewdemo.databinding.ActivitySecondBinding;
import com.example.recycleviewdemo.model.MenuAdapter;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ActivitySecondBinding binding2;
    MenuAdapter adapter;
    RecyclerView recyclerView;
    androidx.recyclerview.widget.LinearLayoutManager layoutManager;
    androidx.recyclerview.widget.GridLayoutManager gridManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        binding2 = ActivitySecondBinding.inflate(getLayoutInflater());

        // 主要 Activity 改為 LoginActivity
        // 後續activity 才能判斷登入身分 切換 不同版面 例如: 管理者權限 跟普通員工
        setContentView(binding.getRoot() );
        adapter = new MenuAdapter();
        recyclerView = binding.menuList;
        // 綁定資料配接器(負責抓資料跟產生 ViewHolder)
        recyclerView.setAdapter(adapter);
        // 設定 layout
        layoutManager = new LinearLayoutManager(this);
        gridManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        /*
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "選單觸發click ", Toast.LENGTH_SHORT).show();
            }
        });
        */

    }

}