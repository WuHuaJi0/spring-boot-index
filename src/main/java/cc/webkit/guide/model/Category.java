package cc.webkit.guide.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    protected Category() {

    }

    // todo: 自定义构造函数，传参
//    public Category() {
//
//    }

    public long getId() {
        return id;
    }

}
