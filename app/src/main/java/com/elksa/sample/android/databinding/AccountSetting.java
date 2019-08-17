package com.elksa.sample.android.databinding;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class AccountSetting extends BaseObservable {

    private String accountName;
    private boolean notifications;
    private boolean deals;
    private boolean promos;
    private String communicationMode;
    private String defaultPaymentOption;
    private int priceDropPercent;
    private int productReviews;
    private boolean promoNotification;

    @Bindable
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
        notifyPropertyChanged(BR.accountName);
    }

    public boolean isNotifications() {
        return notifications;
    }

    public void setNotifications(boolean notifications) {
        this.notifications = notifications;
    }

    public boolean isDeals() {
        return deals;
    }

    public void setDeals(boolean deals) {
        this.deals = deals;
    }

    public boolean isPromos() {
        return promos;
    }

    public void setPromos(boolean promos) {
        this.promos = promos;
    }

    public String getCommunicationMode() {
        return communicationMode;
    }

    public void setCommunicationMode(String communicationMode) {
        this.communicationMode = communicationMode;
    }

    @Bindable
    public String getDefaultPaymentOption() {
        return defaultPaymentOption;
    }

    public void setDefaultPaymentOption(String defaultPaymentOption) {
        this.defaultPaymentOption = defaultPaymentOption;
        notifyPropertyChanged(BR.defaultPaymentOption);
    }

    public int getPriceDropPercent() {
        return priceDropPercent;
    }

    public void setPriceDropPercent(int priceDropPercent) {
        this.priceDropPercent = priceDropPercent;
    }

    public int getProductReviews() {
        return productReviews;
    }

    public void setProductReviews(int productReviews) {
        this.productReviews = productReviews;
    }

    public boolean isPromoNotification() {
        return promoNotification;
    }

    public void setPromoNotification(boolean promoNotification) {
        this.promoNotification = promoNotification;
    }
}
