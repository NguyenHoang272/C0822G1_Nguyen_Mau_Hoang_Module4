package blogmanagement.blogmanagement.service;

import blogmanagement.blogmanagement.dto.BlogDto;
import blogmanagement.blogmanagement.model.Blog;
import blogmanagement.blogmanagement.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(int id);

    void update(Blog blog);

    void remove(int id);

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> searchByTitle(String title, Pageable pageable);

    List<BlogDto> showListDto();

    List<Blog> findByCategory(Category category);

    List<Blog> findAllBlog();


    Page<Blog> findPageable(Pageable pageable);

    List<Blog> findByTitleContaining(String title);
}
