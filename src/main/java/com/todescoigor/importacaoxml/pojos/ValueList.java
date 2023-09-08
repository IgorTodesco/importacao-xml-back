package com.todescoigor.importacaoxml.pojos;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class ValueList {
    private List<Double> values;

    @XmlElement(name = "valor")
    public List<Double> getValues() {
        return values;
    }

    public void setValues(List<Double> values) {
        this.values = values;
    }
}
