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
    // Repository の createメソッドを呼び出す処理をここで追加
    // createの引数として BlogForm クラスを受け取ることでゲッターを呼びだす。
    public void create(BlogForm form){
        blogRepository.create(form.getTitle(), form.getContent());
    }
}
