package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";

    private String mForecast;
    private TextView mWeatherDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mWeatherDisplay = (TextView) findViewById(R.id.tv_display_weather);

        Intent intentThatStartedThisActivity = getIntent();

        if (intentThatStartedThisActivity != null) {
            if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
                mForecast = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT);
                mWeatherDisplay.setText(mForecast);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.detail, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_share) {
            shareWeather();
        }


        return super.onOptionsItemSelected(item);
    }

    private void shareWeather() {

        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .setText(mForecast)
                .setChooserTitle("Share weather to")
                .setType("text/plain")
                .getIntent();

        if (shareIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(shareIntent);
        }
    }

    // complete (3) Create a menu with an item with id of action_share
    // complete (4) Display the menu and implement the forecast sharing functionality
}