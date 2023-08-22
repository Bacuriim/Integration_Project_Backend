package com.br.eletra.model;

import javax.persistence.*;

@Entity
@Table(name = "metercategory")
public class MeterCategoryEntity {

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

    public MeterLineEntity getLine() {
        return line;
    }

    public Short setId(Short id) {
        this.id = id;
        return id;
    }
}