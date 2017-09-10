package com.github.andrejnazarov.shops.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.andrejnazarov.shops.R;
import com.github.andrejnazarov.shops.bean.ShopItem;

import java.util.List;

/**
 * @author Nazarov on 10.09.17.
 */

public class ShopItemAdapter extends RecyclerView.Adapter<ShopItemViewHolder> {

    private final List<ShopItem> mShopItemList;
    private final OnShopItemClickListener mClickListener;

    public ShopItemAdapter(List<ShopItem> shopItemList,
                           OnShopItemClickListener clickListener) {
        mShopItemList = shopItemList;
        mClickListener = clickListener;
    }

    @Override
    public ShopItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_item, parent, false);
        return new ShopItemViewHolder(view, mClickListener);
    }

    @Override
    public void onBindViewHolder(ShopItemViewHolder holder, int position) {
        ShopItem item = mShopItemList.get(position);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(item.getCountry());
        stringBuilder.append(" ");
        stringBuilder.append(item.getTown());
        stringBuilder.append(" ");
        stringBuilder.append(item.getMetro());
        stringBuilder.append(" ");
        stringBuilder.append(item.getAddress());
        stringBuilder.append(" ");
        stringBuilder.append(item.getPhone());
        holder.setAddress(stringBuilder.toString());
    }

    @Override
    public int getItemCount() {
        return mShopItemList.size();
    }
}
