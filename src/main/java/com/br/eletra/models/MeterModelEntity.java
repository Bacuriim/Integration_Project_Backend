package com.br.eletra.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "metermodel")
public class MeterModelEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Short id;

    @Column(name = "name")
    private String modelName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private MeterCategoryEntity category;

    public MeterModelEntity() {}

    MeterModelEntity(MeterCategoryEntity category , String modelName){
        this.category = category;
        this.modelName = modelName;
    }

    @Override
    public String toString(){
        return modelName;
    }

    public Short setId(Short id) {
        this.id = id;
        return id;
    }

    public Short getId() {
        return id;
    }

    public String getModelName() {
        return modelName;
    }

    public MeterCategoryEntity getCategory() {
        return category;
    }

    public Short getId(short id) {
        return id;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setCategory(MeterCategoryEntity category) {
        this.category = category;
    }
}
