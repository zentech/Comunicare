package org.techgeorge.comunicare.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import org.techgeorge.comunicare.R;


public class HomeFragment extends Fragment {
    private GridLayout gridLayout;
    private CardView meCardView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        gridLayout = view.findViewById(R.id.home_grid);
        setClickEvent(gridLayout);
        return view;
    }

    /**
     * click listener for cardview in home fragment
     */
    private void setClickEvent(final GridLayout gridLayout) {
        for(int i = 0; i < gridLayout.getChildCount(); i++) {
            final CardView cardView = (CardView) gridLayout.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final ViewGroup viewGroup = (ViewGroup) cardView.getChildAt(0);
                    String text = ((TextView) viewGroup.getChildAt(1)).getText().toString().toUpperCase();
                    CustomFragment customFragment = new CustomFragment();
                    Bundle args = new Bundle();
                    args.putString("categories", text);
                    customFragment.setArguments(args);
                    getFragmentManager().beginTransaction().add(R.id.fragment_layout, customFragment).commit();
                }
            });
        }
    }

}
