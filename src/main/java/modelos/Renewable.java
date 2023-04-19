
package modelos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "grams",
    "litres"
})
public class Renewable {

    @JsonProperty("grams")
    private Double grams;
    @JsonProperty("litres")
    private Double litres;

    @JsonProperty("grams")
    public Double getGrams() {
        return grams;
    }

    @JsonProperty("grams")
    public void setGrams(Double grams) {
        this.grams = grams;
    }

    @JsonProperty("litres")
    public Double getLitres() {
        return litres;
    }

    @JsonProperty("litres")
    public void setLitres(Double litres) {
        this.litres = litres;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Renewable.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("grams");
        sb.append('=');
        sb.append(((this.grams == null)?"<null>":this.grams));
        sb.append(',');
        sb.append("litres");
        sb.append('=');
        sb.append(((this.litres == null)?"<null>":this.litres));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
