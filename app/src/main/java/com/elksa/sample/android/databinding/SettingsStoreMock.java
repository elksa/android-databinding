package com.elksa.sample.android.databinding;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import androidx.annotation.NonNull;

class SettingsStoreMock {

    // region Constants
    private final String KEY_ACCOUNT_NAME = "key_account_name";
    private final String KEY_NOTIFICATIONS = "key_notifications";
    private final String KEY_DEALS = "key_deals";
    private final String KEY_PROMOS = "key_promos";
    private final String KEY_COMMUNICATION_MODE = "key_communication_mode";
    private final String KEY_DEFAULT_PAYMENT_OPTIONS = "key_payment_options";
    private final String KEY_PRICE_DROP_PERCENT = "key_price_drop_percent";
    private final String KEY_PRODUCT_REVIEWS = "key_product_reviews";
    private final String KEY_PROMO_NOTIFICATIONS = "key_promo_notifications";
    // endregion

    // region Fields
    private SharedPreferences preferences;
    // endregion

    SettingsStoreMock(@NonNull Context context) {
        preferences = context.getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
    }

    AccountSetting loadSettings() {

        AccountSetting accountSetting = new AccountSetting();

        accountSetting.setAccountName(preferences.getString(KEY_ACCOUNT_NAME, null));
        accountSetting.setNotifications(preferences.getBoolean(KEY_NOTIFICATIONS, false));
        accountSetting.setDeals(preferences.getBoolean(KEY_DEALS, false));
        accountSetting.setPromos(preferences.getBoolean(KEY_PROMOS, false));
        accountSetting.setCommunicationMode(preferences.getString(KEY_COMMUNICATION_MODE, null));
        accountSetting.setDefaultPaymentOption(preferences.getString(KEY_DEFAULT_PAYMENT_OPTIONS, null));
        accountSetting.setPriceDropPercent(preferences.getInt(KEY_PRICE_DROP_PERCENT, 0));
        accountSetting.setProductReviews(preferences.getInt(KEY_PRODUCT_REVIEWS, 0));
        accountSetting.setPromoNotification(preferences.getBoolean(KEY_PROMO_NOTIFICATIONS, false));

        return accountSetting;
    }

    void saveSettings(AccountSetting accountSetting) {

        Editor editor = preferences.edit();

        editor.putString(KEY_ACCOUNT_NAME, accountSetting.getAccountName());
        editor.putBoolean(KEY_NOTIFICATIONS, accountSetting.isNotifications());
        editor.putBoolean(KEY_DEALS, accountSetting.isDeals());
        editor.putBoolean(KEY_PROMOS, accountSetting.isPromos());
        editor.putString(KEY_COMMUNICATION_MODE, accountSetting.getCommunicationMode());
        editor.putString(KEY_DEFAULT_PAYMENT_OPTIONS, accountSetting.getDefaultPaymentOption());
        editor.putInt(KEY_PRICE_DROP_PERCENT, accountSetting.getPriceDropPercent());
        editor.putInt(KEY_PRODUCT_REVIEWS, accountSetting.getProductReviews());
        editor.putBoolean(KEY_PROMO_NOTIFICATIONS, accountSetting.isPromoNotification());

        editor.apply();
    }
}
