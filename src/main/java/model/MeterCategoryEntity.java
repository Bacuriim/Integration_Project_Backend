package model;

import javax.persistence.*;

@Entity
@Table(name = "metercategory")
public class MeterCategoryEntity {

    @Id
    @Column(name = "nameid")
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
}
