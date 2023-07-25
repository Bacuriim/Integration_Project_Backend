package model;

import javax.persistence.*;

@Entity
@Table(name = "model_table")
public class ModelEntity {

    @Id
    @Column(name = "model_name")
    private String modelName;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategoryEntity category;

    public ModelEntity() {}

    public ModelEntity(CategoryEntity category , String modelName){
        this.category = category;
        this.modelName = modelName;
    }

    @Override
    public String toString(){
        return modelName;
    }

    public CategoryEntity getCategory() {
        return category;
    }
}
