package com.example.android.sunshine;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.LayoutInflater;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {

    String[] mWeatherData;

    ForecastAdapter() {

    }

    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.forecast_list_item, parent, false);

        ForecastAdapterViewHolder holder = new ForecastAdapterViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        String weather = mWeatherData[position];
        holder.bind(weather);
    }

    @Override
    public int getItemCount() {
        if (mWeatherData == null) {
            return 0;
        } else {
            return mWeatherData.length;
        }
    }

    public void setWeatherData(String[] weatherData) {
        mWeatherData = weatherData;
        notifyDataSetChanged();
    }

    class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {
        public final TextView mWeatherTextView;

        ForecastAdapterViewHolder(View view) {
            super(view);
            mWeatherTextView = (TextView) view.findViewById(R.id.tv_weather_data);
        }

        void bind(String weather) {
            mWeatherTextView.setText(weather);
        }
    }

}
