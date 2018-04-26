package com.example.vojmi.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * {@link Fragment} displaying a list of places.
 */
public class FRG_Architecture extends Fragment {
    public FRG_Architecture() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.places_lst, container, false);
        // Creating the list of places.
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(R.string.a_1_title, R.string.a_1_description, R.drawable.a1, 49.194534, 16.599188));
        places.add(new Place(R.string.a_2_title, R.string.a_2_description, R.drawable.a2, 49.191050, 16.607525));
        places.add(new Place(R.string.a_3_title, R.string.a_3_description, R.drawable.a3, 49.192402, 16.609100));
        places.add(new Place(R.string.a_4_title, R.string.a_4_description, R.drawable.a4, 49.197683, 16.603258));
        places.add(new Place(R.string.a_5_title, R.string.a_5_description, R.drawable.a5, 49.207156, 16.616071));
        places.add(new Place(R.string.a_6_title, R.string.a_6_description, R.drawable.a6, 49.187958, 16.582187));
        // Creating an object ADPTR_Places. The data source is a list of places. The
        // adapter is defined to manage the list items.
        ADPTR_Places adapter = new ADPTR_Places(getActivity(), places, R.color.cat_1_col);
        // Finding the ListView object in the view of the Activity according to ID list.
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        // Making the ListView to use the ADPTR_Places from above.
        listView.setAdapter(adapter);
        // Setting the click listener to open map of the current place.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Getting the ID of the item we want to get resource.
                Place place = places.get(position);
                // Concatenation of resources to get the correct Uri link.
                Uri gmmIntentUri = Uri.parse("geo:" + place.getmLatitude() + "," + place.getmLongitude() + "?z=18");
                // Defining mapIntent object.
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                // Definition of default action for this intent.
                mapIntent.setPackage("com.google.android.apps.maps");
                // Start of the actual intent.
                startActivity(mapIntent);
            }
        });
        return rootView;
    }
}
