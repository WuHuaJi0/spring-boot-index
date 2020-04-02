package cc.webkit.guide.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String url;
    private long categoryId;
    private String desc;


    protected Url() { }

    public Url(String username, String url, long categoryId, String desc) {
        this.username = username;
        this.url = url;
        this.categoryId = categoryId;
        this.desc = desc;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getUrl() {
        return url;
    }

    public long getCategoryId() {
        return categoryId;
    }


    public String getDesc() {
        return desc;
    }
}
