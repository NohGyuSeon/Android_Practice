package com.example.app8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        final ProductAdapter adapter = new ProductAdapter();

        adapter.addItem(new Product("롱코트", "90만", "명절 기획상품", R.drawable.birdmissile1));
        adapter.addItem(new Product("빈탄 와이셔츠", "190만", "특가상품", R.drawable.birdmissile2));
        adapter.addItem(new Product("휠라", "9만", "12개 남음", R.drawable.birdmissile3));
        adapter.addItem(new Product("슈프림", "90만", "품절 임박", R.drawable.birdmissile4));
        adapter.addItem(new Product("아메리카노", "0.9만", "1456개 남음", R.drawable.birdmissile5));
        adapter.addItem(new Product("조던", "100만", "명절 기획상품", R.drawable.birdmissile6));
        adapter.addItem(new Product("버드미사일", "1290만", "품절", R.drawable.birdmissile1));
        adapter.addItem(new Product("비행기", "1910만", "품절 임박", R.drawable.birdmissile2));
        adapter.addItem(new Product("루이", "98만", "초특가 상품", R.drawable.birdmissile3));

        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnProductItemClickListener() {
            @Override
            public void onItemClick(ProductAdapter.ViewHolder holder, View view, int position) {
                Product item = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "이름 : " + item.getName() + "\n 가격: " + item.getCost() +
                        "\n 설명 : " + item.getNotification(),Toast.LENGTH_LONG).show();
            }
        });

    }
}