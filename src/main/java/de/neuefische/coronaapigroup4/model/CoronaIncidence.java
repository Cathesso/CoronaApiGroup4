package de.neuefische.coronaapigroup4.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


public class CoronaIncidence {
    private String country;
    private int cases;
    private String date;

    public String getCountry() {
        return country;
    }
    @JsonProperty("Country")
    public void setCountry(String country) {
        this.country = country;
    }

    public int getCases() {
        return cases;
    }

    @JsonProperty("Cases")
    public void setCases(int cases) {
        this.cases = cases;
    }

    public String getDate() {
        return date;
    }

    @JsonProperty("Date")
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoronaIncidence coronaIncidence = (CoronaIncidence) o;
        return cases == coronaIncidence.cases && Objects.equals(country, coronaIncidence.country) && Objects.equals(date, coronaIncidence.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, cases, date);
    }

    @Override
    public String toString() {
        return "Corona{" +
                "country='" + country + '\'' +
                ", cases=" + cases +
                ", date='" + date + '\'' +
                '}';
    }
}
