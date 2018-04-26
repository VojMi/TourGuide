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
public class FRG_Statues extends Fragment {
    public FRG_Statues (){
    }

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.places_lst,container,false);
        // Creating the list of places.
        final ArrayList<Place> places=new ArrayList<Place>();
        places.add(new Place(R.string.s_1_title,R.string.s_1_description,R.drawable.s1,49.197643, 16.607542));
        places.add(new Place(R.string.s_2_title,R.string.s_2_description,R.drawable.s2,49.198524, 16.603306));
        places.add(new Place(R.string.s_3_title,R.string.s_3_description,R.drawable.s3,49.194800, 16.608579));
        places.add(new Place(R.string.s_4_title,R.string.s_4_description,R.drawable.s4,49.199495, 16.608672));
        places.add(new Place(R.string.s_5_title,R.string.s_5_description,R.drawable.s5,49.197479, 16.607099));
        places.add(new Place(R.string.s_6_title,R.string.s_6_description,R.drawable.s6,49.195291, 16.613296

        ));
        ADPTR_Places adapter = new ADPTR_Places(getActivity(),places,R.color.cat_3_col);
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
