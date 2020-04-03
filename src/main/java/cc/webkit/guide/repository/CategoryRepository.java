package cc.webkit.guide.repository;

import cc.webkit.guide.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Iterable<Category> findAll();
}
