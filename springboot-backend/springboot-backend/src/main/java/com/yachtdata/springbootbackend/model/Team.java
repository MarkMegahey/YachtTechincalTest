package com.yachtdata.springbootbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "team"
)
public class Team {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long teamId;
    private String name;
    private Long marker;
    private Long serial;

    public Team() {
    }

    public Team(Long marker, String name, Long serial) {
        this.marker = marker;
        this.name = name;
        this.serial = serial;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMarker() {
        return this.marker;
    }

    public void setMarker(Long marker) {
        this.marker = marker;
    }

    public Long getSerial() {
        return this.serial;
    }

    public void setSerial(Long serial) {
        this.serial = serial;
    }
}
