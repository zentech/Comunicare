package org.techgeorge.comunicare.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.techgeorge.comunicare.R;
import org.techgeorge.comunicare.classes.Phrases;
import org.techgeorge.comunicare.fragments.CustomFragment;

import java.util.ArrayList;

public class PhrasesAdapter extends ArrayAdapter<String> {
    private String categories;
    public PhrasesAdapter(Context context, int num, ArrayList<String> phrases) {
        super(context, 0, phrases);
        categories = CustomFragment.categories;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        int phraseIndex = position;
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.entry_item, parent, false);
        }
        // Lookup view for data population
        ImageView deleteItemImgview = convertView.findViewById(R.id.delete_item_imageview);
        TextView phrasesTxtView = convertView.findViewById(R.id.phrase_textview);
        deleteItemImgview.setImageResource(R.drawable.ic_delete_black_24dp);

        phrasesTxtView.setText(Phrases.allPhrases.get(categories).get(position));

        deleteItemImgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Phrases.allPhrases.get(categories).remove(position);
                notifyDataSetChanged();
            }
        });

        // Return the completed view to render on screen
        return convertView;
    }
}