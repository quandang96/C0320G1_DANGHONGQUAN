package com.blog.controllers;
import com.blog.model.Category;
import com.blog.model.Post;
import com.blog.service.CategoryService;
import com.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@SessionAttributes("categories")
@Controller
public class PostController {
    @Autowired
    PostService postService;

    @Autowired
    CategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> categories(){
        return categoryService.findAllCategory();
    }

    @GetMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("create","post",new Post());
    }

    @PostMapping("/create")
    public ModelAndView create(Post post){
       postService.save(post);
        return new ModelAndView("create","post",new Post()).addObject("message","Success!");
    }
    @GetMapping("/list/{page}")
    public ModelAndView getPost(@RequestParam(required = false,defaultValue = "") String title,@RequestParam(required = false,defaultValue = "") String category, @PathVariable("page") int page){
        Page<Post> posts;
        ModelAndView modelAndView = new ModelAndView("list");
        if(!title.equals("") || !category.equals("")) {
            posts = postService.findAllByTitleAndCategory(title, category,page);
        }else {
            posts = postService.findAll(page);
        }
        modelAndView.addObject("title",title);
        modelAndView.addObject("category",category);
        modelAndView.addObject("post",posts);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEdit(@PathVariable Long id){

        return new ModelAndView("edit","post",postService.findById(id));
    }

    @PostMapping("/edit")
    public String edit(Post post){
        postService.save(post);
        return "redirect:/list/1";
    }
    @GetMapping("/delete/{id}")
    public ModelAndView getDelete(@PathVariable Long id){
        Post post = postService.findById(id);
        return new ModelAndView("delete","post",post);
    }

    @PostMapping("/delete")
    public String delete(Post post){
        postService.remove(post.getId());
        return "redirect:/list/1";
    }
    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable Long id){
        return new ModelAndView("view","post",postService.findById(id));
    }

    @GetMapping("/{page}")
    public ModelAndView home(@PathVariable(value = "page",required = false ) int page){
        return new ModelAndView("index","post",postService.findAll(page));
    }

    @GetMapping("/")
    public ModelAndView home(){
        return new ModelAndView("index","post",postService.findAll(1));
    }

    @GetMapping("/category/{page}")
    public ModelAndView category(@RequestParam String category,@PathVariable("page") int page){
        ModelAndView modelAndView =new ModelAndView("category");
        modelAndView.addObject("post",postService.findAllByTitleAndCategory("",category,page));
        modelAndView.addObject("category",category);
     return modelAndView;
    }

}

