
package modelos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "grid",
    "renewable"
})
public class Co2 {

    @JsonProperty("grid")
    private Grid grid;
    @JsonProperty("renewable")
    private Renewable renewable;

    @JsonProperty("grid")
    public Grid getGrid() {
        return grid;
    }

    @JsonProperty("grid")
    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    @JsonProperty("renewable")
    public Renewable getRenewable() {
        return renewable;
    }

    @JsonProperty("renewable")
    public void setRenewable(Renewable renewable) {
        this.renewable = renewable;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Co2 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("grid");
        sb.append('=');
        sb.append(((this.grid == null)?"<null>":this.grid));
        sb.append(',');
        sb.append("renewable");
        sb.append('=');
        sb.append(((this.renewable == null)?"<null>":this.renewable));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
