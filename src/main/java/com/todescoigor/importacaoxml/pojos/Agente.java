package com.todescoigor.importacaoxml.pojos;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Agente {
     private Long code;
    private String date;

    private List<Regiao> regions;

    @XmlElement(name = "codigo")
    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    @XmlElement(name = "data")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @XmlElement(name = "regiao")
    public List<Regiao> getRegions() {
        return regions;
    }

    public void setRegions(List<Regiao> regions) {
        this.regions = regions;
    }
}
