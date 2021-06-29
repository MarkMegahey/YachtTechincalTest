package com.yachtdata.springbootbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.json.simple.JSONObject;

@Entity
@Table(
        name = "position"
)
public class Position {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long positionId;
    @ManyToOne
    private Team team;
    private Boolean alert;
    private Long altitude;
    private String type;
    private Double dtfKm;
    private Long id;
    private String gpsAt;
    private Double sogKnots;
    private Long battery;
    private Long cog;
    private Double dtfNm;
    private String txAt;
    private Double longitude;
    private Double latitude;
    private Long gpsAtMillis;
    private Double sogKmph;

    public Position() {
    }

    public Position(Team team, JSONObject position) {
        this.team = team;
        this.alert = (Boolean)position.get("alert");
        this.altitude = (Long)position.get("altitude");
        this.type = (String)position.get("type");
        this.dtfKm = Double.parseDouble(position.get("dtfKm").toString());
        this.id = (Long)position.get("id");
        this.gpsAt = (String)position.get("gpsAt");
        this.sogKnots = Double.parseDouble(position.get("sogKnots").toString());
        this.battery = (Long)position.get("battery");
        this.cog = (Long)position.get("cog");
        this.dtfNm = Double.parseDouble(position.get("dtfNm").toString());
        this.txAt = (String)position.get("txAt");
        this.longitude = (Double)position.get("longitude");
        this.latitude = (Double)position.get("latitude");
        this.gpsAtMillis = (Long)position.get("gpsAtMillis");
        this.sogKmph = Double.parseDouble(position.get("sogKmph").toString());
    }

    public Team getTeam() {
        return this.team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Boolean getAlert() {
        return this.alert;
    }

    public void setAlert(Boolean alert) {
        this.alert = alert;
    }

    public Long getAltitude() {
        return this.altitude;
    }

    public void setAltitude(Long altitude) {
        this.altitude = altitude;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getDtfKm() {
        return this.dtfKm;
    }

    public void setDtfKm(Double dtfKm) {
        this.dtfKm = dtfKm;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGpsAt() {
        return this.gpsAt;
    }

    public void setGpsAt(String gpsAt) {
        this.gpsAt = gpsAt;
    }

    public Double getSogKnots() {
        return this.sogKnots;
    }

    public void setSogKnots(Double sogKnots) {
        this.sogKnots = sogKnots;
    }

    public Long getBattery() {
        return this.battery;
    }

    public void setBattery(Long battery) {
        this.battery = battery;
    }

    public Long getCog() {
        return this.cog;
    }

    public void setCog(Long cog) {
        this.cog = cog;
    }

    public Double getDtfNm() {
        return this.dtfNm;
    }

    public void setDtfNm(Double dtfNm) {
        this.dtfNm = dtfNm;
    }

    public String getTxAt() {
        return this.txAt;
    }

    public void setTxAt(String txAt) {
        this.txAt = txAt;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Long getGpsAtMillis() {
        return this.gpsAtMillis;
    }

    public void setGpsAtMillis(Long gpsAtMillis) {
        this.gpsAtMillis = gpsAtMillis;
    }

    public Double getSogKmph() {
        return this.sogKmph;
    }

    public void setSogKmph(Double sogKmph) {
        this.sogKmph = sogKmph;
    }
}