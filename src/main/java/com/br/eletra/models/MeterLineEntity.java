package com.br.eletra.models;

import javax.persistence.*;

@Entity
@Table(name = "meterline")
public class MeterLineEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Short id;

    @Column(name = "name")
    private String lineName;

    public MeterLineEntity(){}

    public MeterLineEntity(String lineName) {
        this.lineName = lineName;
    }

    @Override
    public String toString() {
        return lineName;
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
}
