
package ch.bbw.mn.fahrplan.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConnectionResponse {

    @SerializedName("connections")
    @Expose
    private List<Connection> connections = new ArrayList<Connection>();

    public List<Connection> getConnections() {
        return connections;
    }

    public void setConnections(List<Connection> connections) {
        this.connections = connections;
    }

}
