package cc.webkit.guide.model;

import javax.persistence.*;

@Entity
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String url;

    private long categoryId;
    private String description;

    protected Url() {

    }

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
