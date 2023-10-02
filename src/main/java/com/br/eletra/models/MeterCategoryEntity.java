package com.br.eletra.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "metercategory")
public class MeterCategoryEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Short id;

    @Column(name = "name")
    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "line_id")
    private MeterLineEntity line;

    public MeterCategoryEntity(String name , Short id) {
        setCategoryName(name);
        setId(id);
    }

    public MeterCategoryEntity() {
        
    }

    public String getLine() {

        return line.getLineName();
    }

    public Short getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setLine(MeterLineEntity line) {
        this.line = line;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "MeterCategoryEntity{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", line=" + line +
                '}';
    }
}
