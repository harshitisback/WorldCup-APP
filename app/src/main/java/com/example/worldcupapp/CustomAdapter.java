package com.example.worldcupapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<CountryModel> {
    private ArrayList<CountryModel> countryArraylist;
    Context context;

    public  CustomAdapter(ArrayList<CountryModel> data, Context context){
        super(context, R.layout.item_list_layout, data);
        this.countryArraylist = data;
        this.context = context;
    }

    // view Lookup cache
    private  static  class  ViewHolder{
        TextView txtCountry;
        TextView txtCupWins;
        ImageView flagImage;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        CountryModel countryModel = getItem(position);

        // chekc if an existing view is being reused , otherwise inflate the view
        ViewHolder viewHolder;
        final View result;

        if(convertView == null){
            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(
                    R.layout.item_list_layout,
                    parent,
                    false
                    );

            viewHolder.txtCountry = (TextView) convertView.findViewById(R.id.country_name);
            viewHolder.txtCupWins = (TextView) convertView.findViewById(R.id.cup_win_desc);
            viewHolder.flagImage = (ImageView) convertView.findViewById(R.id.imageview);

            result = convertView;
            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        // get the data from the model class
        viewHolder.txtCountry.setText(countryModel.getCountry_name());
        viewHolder.txtCupWins.setText(countryModel.getCup_win_count());
        viewHolder.flagImage.setImageResource(countryModel.getFlag_img());

        return  convertView;


    }
}
