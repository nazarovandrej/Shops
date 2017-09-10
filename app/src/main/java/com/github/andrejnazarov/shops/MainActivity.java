package com.github.andrejnazarov.shops;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.andrejnazarov.shops.bean.BaseResponse;
import com.github.andrejnazarov.shops.bean.ShopItem;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ShopsFragment.OnShopItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData();
    }

    @Override
    public void onFragmentInteraction(ShopItem item) {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.map_container, MapViewFragment.newInstance(item.getLatitude(), item.getLongtitude()))
                .commit();
    }

    private void getData() {
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("http://app.ecco-shoes.ru/shops/list").newBuilder();
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                // TODO: 09.09.17 handle failure
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (response.isSuccessful()) {
                    ObjectMapper objectMapper = new ObjectMapper();
                    byte[] bytes = response.body().bytes();
                    BaseResponse baseResponse = objectMapper.readValue(bytes, BaseResponse.class);
                    showShopFragment(baseResponse.getShopItemList());
                } else {
                    // TODO: 09.09.17 handle error
                }
            }
        });
    }

    private void showShopFragment(List<ShopItem> shopItemList) {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.items_container, ShopsFragment.newInstance(shopItemList))
                .commit();
    }
}
