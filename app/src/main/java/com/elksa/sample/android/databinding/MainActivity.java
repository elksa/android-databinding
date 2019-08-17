package com.elksa.sample.android.databinding;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.elksa.sample.android.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements SettingsEventListener {

    private SettingsStoreMock settingsStoreMock;
    private ActivityMainBinding binding;
    private AccountSetting accountSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setEventListener(this);
        String[] paymentOptions = getResources().getStringArray(R.array.payment_options);
        binding.setSpinAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, paymentOptions));

        settingsStoreMock = new SettingsStoreMock(this);
        loadSettings();
    }

    private void loadSettings() {

        accountSetting = settingsStoreMock.loadSettings();

        if (accountSetting.getCommunicationMode() == null) {
            accountSetting.setCommunicationMode("");
        }

        // Bind data
        binding.setAccountSettings(accountSetting);
    }

    public void onClickSaveSettings(View v) {
        accountSetting.setAccountName(accountSetting.getAccountName().toUpperCase());
        saveSettings(accountSetting);
    }

    public void onCommunicationMode(String commMode) {
        accountSetting.setCommunicationMode(commMode);
    }

    private void saveSettings(AccountSetting accountSetting) {
        settingsStoreMock.saveSettings(accountSetting);
        Toast.makeText(MainActivity.this, "settings have been saved", Toast.LENGTH_SHORT).show();
    }
}
