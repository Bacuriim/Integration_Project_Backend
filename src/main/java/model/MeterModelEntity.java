package model;

import javax.persistence.*;

@Entity
@Table(name = "metermodel")
public class MeterModelEntity {

    @Id
    @Column(name = "id")
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
}
