package blogmanagement.blogmanagement.service.impl;

import blogmanagement.blogmanagement.dto.BlogDto;
import blogmanagement.blogmanagement.model.Blog;
import blogmanagement.blogmanagement.model.Category;
import blogmanagement.blogmanagement.repository.IBlogRepository;
import blogmanagement.blogmanagement.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> searchByTitle(String title, Pageable pageable) {
        return iBlogRepository.searchByTitle(title, pageable);
    }

    @Override
    public List<BlogDto> showListDto() {
        return iBlogRepository.showListDto();
    }

    @Override
    public List<Blog> findByCategory(Category category) {
        return iBlogRepository.findByCategory(category);
    }

    @Override
    public List<Blog> findAllBlog() {
        return iBlogRepository.findAll();
    }

    @Override
    public Page<Blog> findPageable(Pageable pageable) {
        return iBlogRepository.findPageable(pageable);
    }

    @Override
    public   List<Blog> findByTitleContaining(String title) {
        return iBlogRepository.findByTitleContaining(title);
    }


}
