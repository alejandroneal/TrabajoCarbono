
package modelos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "url",
    "green",
    "bytes",
    "cleanerThan",
    "statistics",
    "timestamp"
})
public class Carbono {

    @JsonProperty("url")
    private String url;
    @JsonProperty("green")
    private Boolean green;
    @JsonProperty("bytes")
    private Integer bytes;
    @JsonProperty("cleanerThan")
    private Double cleanerThan;
    @JsonProperty("statistics")
    private Statistics statistics;
    @JsonProperty("timestamp")
    private Integer timestamp;

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("green")
    public Boolean getGreen() {
        return green;
    }

    @JsonProperty("green")
    public void setGreen(Boolean green) {
        this.green = green;
    }

    @JsonProperty("bytes")
    public Integer getBytes() {
        return bytes;
    }

    @JsonProperty("bytes")
    public void setBytes(Integer bytes) {
        this.bytes = bytes;
    }

    @JsonProperty("cleanerThan")
    public Double getCleanerThan() {
        return cleanerThan;
    }

    @JsonProperty("cleanerThan")
    public void setCleanerThan(Double cleanerThan) {
        this.cleanerThan = cleanerThan;
    }

    @JsonProperty("statistics")
    public Statistics getStatistics() {
        return statistics;
    }

    @JsonProperty("statistics")
    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    @JsonProperty("timestamp")
    public Integer getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Carbono.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("green");
        sb.append('=');
        sb.append(((this.green == null)?"<null>":this.green));
        sb.append(',');
        sb.append("bytes");
        sb.append('=');
        sb.append(((this.bytes == null)?"<null>":this.bytes));
        sb.append(',');
        sb.append("cleanerThan");
        sb.append('=');
        sb.append(((this.cleanerThan == null)?"<null>":this.cleanerThan));
        sb.append(',');
        sb.append("statistics");
        sb.append('=');
        sb.append(((this.statistics == null)?"<null>":this.statistics));
        sb.append(',');
        sb.append("timestamp");
        sb.append('=');
        sb.append(((this.timestamp == null)?"<null>":this.timestamp));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
