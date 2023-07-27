package model;

import javax.persistence.*;

@Entity
@Table(name = "meterline")
public class MeterLineEntity {

    @Id
    @Column(name = "nameid")
    private String lineName;

    public MeterLineEntity(){}

    MeterLineEntity(String lineName) {
        this.lineName = lineName;
    }

    @Override
    public String toString() {
        return lineName;
    }
}
