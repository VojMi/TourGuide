package com.example.vojmi.tourguide;
/**
 * {@link Place} contains the content of place that is defined in resources.
 * It os defined by IDs for particular place title, place description, place picture
 * as well as the position defined via latitude and longitude.
 * */
public class Place {
    /** This variable links string resource ID containing the place's title. */
    private int mTitle;
    /** This variable links string resource ID containing the place's description. */
    private int mDescription;
    /** This variable links string resource ID containing the place's image. */
    private int mImgResId;
    /** This variable links string resource ID containing the place's latitude. */
    private double mLatitude;
    /** This variable links string resource ID containing the place's longitude. */
    private double mLongitude;
/** Creating a new Place object.
 * @param Title is the string resource ID with the title for particular place.
 * @param  Description is the string resource ID with the description for particular place.
 * @param  ImgResId is the resource ID with the image file for the particular place.
 * @param  Latitude is the string resource ID with the latitude for particular place.
 * @param  Longitude is the string resource ID with the longitude for particular place.*/
    public Place(int Title, int Description, int ImgResId, double Latitude, double Longitude) {
        mTitle = Title;
        mDescription = Description;
        mImgResId = ImgResId;
        mLatitude = Latitude;
        mLongitude = Longitude;
    }
    /** Get the string resource ID for the title of the place. */
    public int getTitle() {
        return mTitle;
    }
    /** Get the string resource ID for the description of the place. */
    public int getDescription() {
        return mDescription;
    }
    /** Returns the resource ID for the image file  representing the place. */
    public int getImgResId() {
        return mImgResId;
    }
    /**Get the string resource ID for the latitude of the place. */
    public double getmLatitude() {
        return mLatitude;
    }
    /**Get the string resource ID for the longitude of the place. */
    public double getmLongitude() {
        return mLongitude;
    }
}
