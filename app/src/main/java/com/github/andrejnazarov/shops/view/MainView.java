package com.github.andrejnazarov.shops.view;

import android.support.annotation.StringRes;

import com.arellomobile.mvp.MvpView;
import com.github.andrejnazarov.shops.bean.ShopItem;

import java.util.List;

/**
 * @author Nazarov on 26.11.17.
 */

public interface MainView extends MvpView {

    void showShopsFragment(List<ShopItem> shopItemList);

    void showErrorMessage(@StringRes int errorMessage);
}