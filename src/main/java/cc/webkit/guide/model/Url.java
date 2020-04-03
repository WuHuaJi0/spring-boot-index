package cc.webkit.guide.model;

import javax.persistence.*;

@Entity
@Table(name = "Url")
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String url;

    @Column(name = "categoryId")
    private long categoryId;

    private String description;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="categoryId",nullable = false,insertable = false,updatable = false) //设置在article表中的关联字段(外键)
    private Category category; //所属作者

    protected Url() {}

    public Url(String name, String url, long categoryId, String description) {
        this.name = name;
        this.url = url;
        this.categoryId = categoryId;
        this.description = description;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public String getDescription() {
        return description;
    }
}
