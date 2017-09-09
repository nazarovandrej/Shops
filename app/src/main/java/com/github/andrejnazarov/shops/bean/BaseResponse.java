package com.github.andrejnazarov.shops.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

import java.util.List;

/**
 * @author Nazarov on 09.09.17.
 */
public class BaseResponse {

    @JsonProperty("meta")
    private Meta mMeta;

    @JsonProperty("data")
    private List<ShopItem> mShopItemList;

    public Meta getMeta() {
        return mMeta;
    }

    public List<ShopItem> getShopItemList() {
        return mShopItemList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseResponse that = (BaseResponse) o;
        return Objects.equal(mMeta, that.mMeta) &&
                Objects.equal(mShopItemList, that.mShopItemList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mMeta, mShopItemList);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("mMeta", mMeta)
                .add("mShopItemList", mShopItemList)
                .toString();
    }
}