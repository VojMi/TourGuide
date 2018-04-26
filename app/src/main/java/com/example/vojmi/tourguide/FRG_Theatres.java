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
public class FRG_Theatres extends Fragment {
    public FRG_Theatres (){
    }

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.places_lst,container,false);
        // Creating the list of places.
        final ArrayList<Place> places=new ArrayList<Place>();
        places.add(new Place(R.string.t_1_title,R.string.t_1_description,R.drawable.t1,49.194638, 16.610223));
        places.add(new Place(R.string.t_2_title,R.string.t_2_description,R.drawable.t2,49.191982, 16.607915));
        places.add(new Place(R.string.t_3_title,R.string.t_3_description,R.drawable.t3,49.198009, 16.611599));
        places.add(new Place(R.string.t_4_title,R.string.t_4_description,R.drawable.t4,49.196049, 16.613543));
        places.add(new Place(R.string.t_5_title,R.string.t_5_description,R.drawable.t5,49.201533, 16.608198));
        places.add(new Place(R.string.t_6_title,R.string.t_6_description,R.drawable.t6,49.192103, 16.609322));
        ADPTR_Places adapter = new ADPTR_Places(getActivity(),places,R.color.cat_4_col);
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
