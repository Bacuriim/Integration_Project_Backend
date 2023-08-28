package com.br.eletra.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "metercategory")
public class MeterCategoryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Short id;

    @Column(name = "name")
    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "line_id")
    private MeterLineEntity line;

    public MeterCategoryEntity() {}

    MeterCategoryEntity(MeterLineEntity line , String name){
        this.line = line;
        this.categoryName = name;
    }

    @Override
    public String toString(){
        return categoryName;
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

}
