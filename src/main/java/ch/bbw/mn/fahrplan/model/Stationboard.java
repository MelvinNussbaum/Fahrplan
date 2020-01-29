package ch.bbw.mn.fahrplan.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stationboard {
    
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("to")
    @Expose
    private String to;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getTo() {
        return to;
    }
    
    public void setTo(String to) {
        this.to = to;
    }
    
}