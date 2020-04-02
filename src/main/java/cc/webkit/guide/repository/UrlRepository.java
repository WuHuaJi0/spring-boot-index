package cc.webkit.guide.repository;

import cc.webkit.guide.model.Admin;
import cc.webkit.guide.model.Url;
import org.springframework.data.repository.CrudRepository;

public interface UrlRepository extends CrudRepository<Url, Long> {

}
