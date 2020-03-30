package cc.webkit.guide.mapper;


import cc.webkit.guide.model.Category;

import java.util.List;

public interface CategoryMapper {
    int insert(Category category);

    List<Category> getAll();
}
