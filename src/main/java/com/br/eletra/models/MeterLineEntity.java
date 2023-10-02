package com.br.eletra.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "meterline")
public class MeterLineEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Short id;

    @Column(name = "name")
    private String lineName;

    public MeterLineEntity(String name , Short id){
        setLineName(name);
        setId(id);
    }

    public MeterLineEntity() {

    }

    public Short getId() {
        return id;
    }

    public String getLineName() {
        return lineName;
    }

    public Short setId(Short id) {
        this.id = id;
        return id;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    @Override
    public String toString() {
        return "MeterLineEntity{" +
                "id=" + id +
                ", lineName='" + lineName + '\'' +
                '}';
    }
}
