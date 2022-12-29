package com.blog_management.service.blog_service;


import com.blog_management.model.Blog;
import com.blog_management.model.Category;
import com.blog_management.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) { blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findByTitle(String searchTitle, Pageable pageable) {
        return blogRepository.findByTitleContaining(searchTitle, pageable);
    }

    @Override
    public List<Blog> findByCategory(Category categoryId) {
        return blogRepository.findByCategory(categoryId);
    }

    @Override
    public Page<Blog> findPageable(Pageable pageable) {
        return blogRepository.findPageable(pageable);
    }


    @Override
    public Page<Blog> findByTitleAndCategory(String title, String category, Pageable pageable) {
        return blogRepository.findByTitleAndCategory(title, category, pageable);
    }


}
