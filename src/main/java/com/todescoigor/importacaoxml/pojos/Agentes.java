package com.todescoigor.importacaoxml.pojos;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "agentes")
public class Agentes {
    private List<Agente> agent;

    @XmlElement(name = "agente")
    public List<Agente> getAgent() {
        return agent;
    }

    public void setAgent(List<Agente> agent) {
        this.agent = agent;
    }
}