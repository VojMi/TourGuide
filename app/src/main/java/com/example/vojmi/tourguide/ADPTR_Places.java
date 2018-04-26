package com.example.vojmi.tourguide;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link ADPTR_Places} is an {@link ArrayAdapter} providing the layout for list items based on
 * {@link Place} data resource.
 */
public class ADPTR_Places extends ArrayAdapter<Place> {
    /**
     * Declaring the resource variable for background color of category.
     */
    private int mColorResourceId;

    /**
     * Crating the object {@link ADPTR_Places} with following parameters:
     *
     * @param context         is the current activity to which adapter belongs to
     * @param places          is the list of {@link Place} to be displayed.
     * @param colorResourceId is the ID of category background color.
     */
    public ADPTR_Places(Context context, ArrayList<Place> places, int colorResourceId) {
        super(context, 0, places);
        mColorResourceId = colorResourceId;
    }

    /**
     * The getView is complex method for required display of particular places.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Checks the existing view for beeing reused, if no inflate the view.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.lst_category, parent, false);

        }
        // Get the position of current object in particular position in the list.
        Place currentPlace = getItem(position);
        // Find the TextView in the lst_category layout with the ID title.
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title);
        // Get the title for the currentPlace object and set that text to that TextView variable.
        titleTextView.setText(currentPlace.getTitle());
        // Find the TextView in the lst_category layout with the ID description.
        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description);
        // Get the description for the currentPlace object and set that text to that TextView variable.
        descriptionTextView.setText(currentPlace.getDescription());
        // Find the ImageView in the lst_category layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Get the image resource for the currentPlace object and set displays it.
        imageView.setImageResource(currentPlace.getImgResId());
        // Set the theme colour for the list item.
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the colour that resource ID links to.
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color according to text container View colour.
        textContainer.setBackgroundColor(color);
        //Returns the whole list item layout.
        return listItemView;
    }
}
