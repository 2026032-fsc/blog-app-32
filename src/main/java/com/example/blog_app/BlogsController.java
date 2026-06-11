package com.example.blog_app;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;



@Controller
public class BlogsController {

    private final BlogsService blogsService;

    public BlogsController(BlogsService blogsService) {
        this.blogsService = blogsService;
    }

    @GetMapping("/blogs")
    public String blogs(Model model) {
        model.addAttribute("blogs", blogsService.findAll());
        return "blogs";
    }

    @GetMapping("/")
    public String blog() {
        return "redirect:blogs";
    }

    @GetMapping("/blogs/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Optional<Blog> blogOpt = blogsService.findById(id);
        if (blogOpt.isEmpty()) {
            return "redirect:/blogs";
        }
        model.addAttribute("blog", blogOpt.get());
        return "blogs/detail";
    }
    //登録画面を表示するgetmappingを書く
    @GetMapping("blogs/new")
    public String newBlog(){
        return "blogs/new";
    }

    //フォームからの送信を受け付けるpostmappingを書く
    @PostMapping("blogs")
    public String create(@ModelAttribute BlogForm form){
        blogsService.create(form);
        return "redirect:/blogs";
    }
}

