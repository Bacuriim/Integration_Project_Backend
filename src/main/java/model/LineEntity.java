package model;

import javax.persistence.*;

@Entity
@Table(name = "line_table")
public class LineEntity {

    @Id
    @Column(name = "line_name")
    private String lineName;

    public LineEntity(){}

    LineEntity(String lineName) {
        this.lineName = lineName;
    }

    @Override
    public String toString() {
        return lineName;
    }
}
