package com.github.andrejnazarov.shops.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

/**
 * @author Nazarov on 09.09.17.
 */

public class Meta {

    @JsonProperty("code")
    private int mCode;

    @JsonProperty("error_message")
    private String mErrorMessage;

    @JsonProperty("rows_count")
    private int mRowsCount;

    public int getCode() {
        return mCode;
    }

    public String getErrorMessage() {
        return mErrorMessage;
    }

    public int getRowsCount() {
        return mRowsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meta meta = (Meta) o;
        return mCode == meta.mCode &&
                mRowsCount == meta.mRowsCount &&
                Objects.equal(mErrorMessage, meta.mErrorMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mCode, mErrorMessage, mRowsCount);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("mCode", mCode)
                .add("mErrorMessage", mErrorMessage)
                .add("mRowsCount", mRowsCount)
                .toString();
    }
}