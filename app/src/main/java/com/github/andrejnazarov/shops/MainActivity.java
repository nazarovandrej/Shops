package com.github.andrejnazarov.shops;

import android.support.annotation.StringRes;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.github.andrejnazarov.shops.bean.ShopItem;
import com.github.andrejnazarov.shops.presenter.MainPresenter;
import com.github.andrejnazarov.shops.view.MainView;
import java.util.List;

public class MainActivity extends MvpAppCompatActivity implements MainView, ShopsFragment.OnShopItemClickListener{

    @InjectPresenter
    MainPresenter mMainPresenter;

    FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
    }

    @Override
    public void showShopsFragment(List<ShopItem> shopItemList) {
        mFragmentManager.beginTransaction()
                .replace(R.id.items_container, ShopsFragment.newInstance(shopItemList))
                .commit();
    }

    @Override
    public void showErrorMessage(@StringRes int errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFragmentInteraction(ShopItem item) {
        mFragmentManager.beginTransaction()
                .replace(R.id.map_container, MapViewFragment.newInstance(item.getLatitude(), item.getLongtitude()))
                .commit();
    }
}