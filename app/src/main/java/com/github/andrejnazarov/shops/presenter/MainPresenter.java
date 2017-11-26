package com.github.andrejnazarov.shops.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.andrejnazarov.shops.R;
import com.github.andrejnazarov.shops.bean.BaseResponse;
import com.github.andrejnazarov.shops.view.MainView;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * @author Nazarov on 26.11.17.
 */
@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    public MainPresenter() {
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("http://app.ecco-shoes.ru/shops/list").newBuilder();
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                getViewState().showErrorMessage(R.string.error_message);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (response.isSuccessful()) {
                    ObjectMapper objectMapper = new ObjectMapper();
                    byte[] bytes = response.body().bytes();
                    BaseResponse baseResponse = objectMapper.readValue(bytes, BaseResponse.class);
                    getViewState().showShopsFragment(baseResponse.getShopItemList());
                } else {
                    getViewState().showErrorMessage(R.string.error_message);
                }
            }
        });
    }
}