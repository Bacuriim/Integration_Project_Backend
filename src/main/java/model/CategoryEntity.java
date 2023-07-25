package model;

import javax.persistence.*;

@Entity
@Table(name = "category_table")
public class CategoryEntity {

    @Id
    @Column(name = "category_name")
    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "id_line")
    private LineEntity line;

    public CategoryEntity() {}

    CategoryEntity(LineEntity line ,String name){
        this.line = line;
        this.categoryName = name;
    }

    @Override
    public String toString(){
        return categoryName;
    }

    public LineEntity getLine() {
        return line;
    }
}
