package com.github.andrejnazarov.shops.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

/**
 * @author Nazarov on 09.09.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopItem implements Parcelable {

    public static final ClassCreator CREATOR = new ClassCreator();

    @JsonProperty("name")
    private String mName;

    @JsonProperty("country")
    private String mCountry;

    @JsonProperty("region")
    private String mRegion;

    @JsonProperty("town")
    private String mTown;

    @JsonProperty("address")
    private String mAddress;

    @JsonProperty("metro")
    private String mMetro;

    @JsonProperty("phone")
    private String mPhone;

    @JsonProperty("worktime")
    private String mWorkTime;

    @JsonProperty("type")
    private String mType;

    @JsonProperty("longtitude")
    private double mLongtitude;

    @JsonProperty("latitude")
    private double mLatitude;

    public ShopItem() {
        // Jackson needs empty constructor
    }

    protected ShopItem(Parcel in) {
        mName = in.readString();
        mCountry = in.readString();
        mRegion = in.readString();
        mTown = in.readString();
        mAddress = in.readString();
        mMetro = in.readString();
        mPhone = in.readString();
        mWorkTime = in.readString();
        mType = in.readString();
        mLongtitude = in.readDouble();
        mLatitude = in.readDouble();
    }

    public String getName() {
        return mName;
    }

    public String getCountry() {
        return mCountry;
    }

    public String getRegion() {
        return mRegion;
    }

    public String getTown() {
        return mTown;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getMetro() {
        return mMetro;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getWorkTime() {
        return mWorkTime;
    }

    public String getType() {
        return mType;
    }

    public double getLongtitude() {
        return mLongtitude;
    }

    public double getLatitude() {
        return mLatitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopItem shopItem = (ShopItem) o;
        return Double.compare(shopItem.mLongtitude, mLongtitude) == 0 &&
                Double.compare(shopItem.mLatitude, mLatitude) == 0 &&
                Objects.equal(mName, shopItem.mName) &&
                Objects.equal(mCountry, shopItem.mCountry) &&
                Objects.equal(mRegion, shopItem.mRegion) &&
                Objects.equal(mTown, shopItem.mTown) &&
                Objects.equal(mAddress, shopItem.mAddress) &&
                Objects.equal(mMetro, shopItem.mMetro) &&
                Objects.equal(mPhone, shopItem.mPhone) &&
                Objects.equal(mWorkTime, shopItem.mWorkTime) &&
                Objects.equal(mType, shopItem.mType);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
                mName,
                mCountry,
                mRegion,
                mTown,
                mAddress,
                mMetro,
                mPhone,
                mWorkTime,
                mType,
                mLongtitude,
                mLatitude);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("mName", mName)
                .add("mCountry", mCountry)
                .add("mRegion", mRegion)
                .add("mTown", mTown)
                .add("mAddress", mAddress)
                .add("mMetro", mMetro)
                .add("mPhone", mPhone)
                .add("mWorkTime", mWorkTime)
                .add("mType", mType)
                .add("mLongtitude", mLongtitude)
                .add("mLatitude", mLatitude)
                .toString();
    }

    @JsonIgnore
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mCountry);
        dest.writeString(mRegion);
        dest.writeString(mTown);
        dest.writeString(mAddress);
        dest.writeString(mMetro);
        dest.writeString(mPhone);
        dest.writeString(mWorkTime);
        dest.writeString(mType);
        dest.writeDouble(mLongtitude);
        dest.writeDouble(mLatitude);
    }

    private static final class ClassCreator implements Creator<ShopItem> {
        @Override
        public ShopItem createFromParcel(Parcel in) {
            return new ShopItem(in);
        }

        @Override
        public ShopItem[] newArray(int size) {
            return new ShopItem[size];
        }
    }
}