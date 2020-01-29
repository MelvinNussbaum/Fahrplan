
package ch.bbw.mn.fahrplan.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class From {

    @SerializedName("station")
    @Expose
    private Station station;
    @SerializedName("arrival")
    @Expose
    private Object arrival;
    @SerializedName("arrivalTimestamp")
    @Expose
    private Object arrivalTimestamp;
    @SerializedName("departure")
    @Expose
    private String departure;
    @SerializedName("departureTimestamp")
    @Expose
    private Integer departureTimestamp;
    @SerializedName("delay")
    @Expose
    private Object delay;
    @SerializedName("platform")
    @Expose
    private String platform;
    @SerializedName("prognosis")
    @Expose
    private Prognosis prognosis;
    @SerializedName("realtimeAvailability")
    @Expose
    private Object realtimeAvailability;
    @SerializedName("location")
    @Expose
    private Location location;

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Object getArrival() {
        return arrival;
    }

    public void setArrival(Object arrival) {
        this.arrival = arrival;
    }

    public Object getArrivalTimestamp() {
        return arrivalTimestamp;
    }

    public void setArrivalTimestamp(Object arrivalTimestamp) {
        this.arrivalTimestamp = arrivalTimestamp;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public Integer getDepartureTimestamp() {
        return departureTimestamp;
    }

    public void setDepartureTimestamp(Integer departureTimestamp) {
        this.departureTimestamp = departureTimestamp;
    }

    public Object getDelay() {
        return delay;
    }

    public void setDelay(Object delay) {
        this.delay = delay;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Prognosis getPrognosis() {
        return prognosis;
    }

    public void setPrognosis(Prognosis prognosis) {
        this.prognosis = prognosis;
    }

    public Object getRealtimeAvailability() {
        return realtimeAvailability;
    }

    public void setRealtimeAvailability(Object realtimeAvailability) {
        this.realtimeAvailability = realtimeAvailability;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
