package com.todescoigor.importacaoxml.pojos;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Regiao {
    private String acronym;
    private ValueList generationValueList;
    private ValueList purchaseValueList;

    @XmlAttribute(name = "sigla")
    public String getAcronym() {
        return this.acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    @XmlElement(name = "geracao")
    public ValueList getGenerationValueList() {
        return generationValueList;
    }

    public void setGenerationValueList(ValueList generationValueList) {
        this.generationValueList = generationValueList;
    }

    @XmlElement(name = "compra")
    public ValueList getPurchaseValueList() {
        return purchaseValueList;
    }

    public void setPurchaseValueList(ValueList purchaseValueList) {
        this.purchaseValueList = purchaseValueList;
    }
}
