package com.example.blog_app;

import java.util.Optional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BlogsService {
    private final BlogRepository blogRepository;

    public BlogsService(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }

    public List<Blog> findAll(){
        return blogRepository.findAll();
    }
    public Optional<Blog> findById(Long id){
        return blogRepository.findById(id);
    }
}
