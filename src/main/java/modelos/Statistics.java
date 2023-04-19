
package modelos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "adjustedBytes",
    "energy",
    "co2"
})
public class Statistics {

    @JsonProperty("adjustedBytes")
    private Double adjustedBytes;
    @JsonProperty("energy")
    private Double energy;
    @JsonProperty("co2")
    private Co2 co2;

    @JsonProperty("adjustedBytes")
    public Double getAdjustedBytes() {
        return adjustedBytes;
    }

    @JsonProperty("adjustedBytes")
    public void setAdjustedBytes(Double adjustedBytes) {
        this.adjustedBytes = adjustedBytes;
    }

    @JsonProperty("energy")
    public Double getEnergy() {
        return energy;
    }

    @JsonProperty("energy")
    public void setEnergy(Double energy) {
        this.energy = energy;
    }

    @JsonProperty("co2")
    public Co2 getCo2() {
        return co2;
    }

    @JsonProperty("co2")
    public void setCo2(Co2 co2) {
        this.co2 = co2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Statistics.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("adjustedBytes");
        sb.append('=');
        sb.append(((this.adjustedBytes == null)?"<null>":this.adjustedBytes));
        sb.append(',');
        sb.append("energy");
        sb.append('=');
        sb.append(((this.energy == null)?"<null>":this.energy));
        sb.append(',');
        sb.append("co2");
        sb.append('=');
        sb.append(((this.co2 == null)?"<null>":this.co2));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
