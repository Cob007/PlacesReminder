package michealcob.myapplication.model;

/**
 * Created by michealcob on 1/8/18.
 */

public class Localarm {
    String Title;
    String MyLocationLat;
    String MyLocationLng;
    String MyDestinationLat;
    String MyDestinationLng;

    public Localarm(){

    }
    public Localarm(String _title,  String _myDestinationlat,
                    String _myDestinationlng){/*String _myLocationlat,
                    String  _myLocationlng,
                    this.MyLocationLat = _myLocationlat;
                    this.MyLocationLng = _myLocationlng;
                    */
        this.Title = _title;
        this.MyDestinationLat = _myDestinationlat;
        this.MyDestinationLng = _myDestinationlng;
    }

    public String getTitle() {
        return Title;
    }

    public String getMyDestinationLat() {
        return MyDestinationLat;
    }

    public String getMyLocationLat() {
        return MyLocationLat;
    }

    public String getMyDestinationLng() {
        return MyDestinationLng;
    }

    public String getMyLocationLng() {
        return MyLocationLng;
    }

    public void setMyDestinationLat(String myDestinationLat) {
        MyDestinationLat = myDestinationLat;
    }

    public void setMyLocationLat(String myLocationLat) {
        MyLocationLat = myLocationLat;
    }

    public void setMyDestinationLng(String myDestinationLng) {
        MyDestinationLng = myDestinationLng;
    }

    public void setMyLocationLng(String myLocationLng) {
        MyLocationLng = myLocationLng;
    }

    public void setTitle(String title) {
        Title = title;
    }
}

