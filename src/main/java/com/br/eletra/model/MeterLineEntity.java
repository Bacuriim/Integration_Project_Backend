package com.br.eletra.model;

import javax.persistence.*;

@Entity
@Table(name = "meterline")
public class MeterLineEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    private String lineName;

    public MeterLineEntity(){}

    MeterLineEntity(String lineName) {
        this.lineName = lineName;
    }

    @Override
    public String toString() {
        return lineName;
    }

    public String setId(String id) {
        this.id = id;
        return id;
    }
}
