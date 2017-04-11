package com.example.natan.kickofthecliff.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class KickDTO {

    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("remind_data")
    private Date kickDTO;

    public KickDTO() {
    }

    public KickDTO(String title){
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getKickDTO() {
        return kickDTO;
    }

    public void setKickDTO(Date kickDTO) {
        this.kickDTO = kickDTO;
    }
}
