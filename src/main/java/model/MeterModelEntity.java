package model;

import javax.persistence.*;

@Entity
@Table(name = "metermodel")
public class MeterModelEntity {

    @Id
    @Column(name = "nameid")
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
}
