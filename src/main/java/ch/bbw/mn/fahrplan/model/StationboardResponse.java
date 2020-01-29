package ch.bbw.mn.fahrplan.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StationboardResponse {
    
    @SerializedName("stationboard")
    @Expose
    private List<Stationboard> stationboard = new ArrayList<Stationboard>();
    
    public List<Stationboard> getStationboard() {
        return stationboard;
    }
    
    public void setStationboard(List<Stationboard> stationboard) {
        this.stationboard = stationboard;
    }
}
