
package ch.bbw.mn.fahrplan.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class From {

    @SerializedName("station")
    @Expose
    private Station station;
    @SerializedName("departure")
    @Expose
    private String departure;
    @SerializedName("platform")
    @Expose
    private String platform;

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

}
