package com.blog_webservice.controllers;
import com.blog_webservice.model.Category;
import com.blog_webservice.model.Post;
import com.blog_webservice.service.CategoryService;
import com.blog_webservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@SessionAttributes("categories")
@RestController
public class PostController {
    @Autowired
    PostService postService;

    @Autowired
    CategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.findAllCategory();
    }


    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody Post post) {
        postService.save(post);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/blog", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Post>> getPost() {
        Page<Post> posts;
        posts = postService.findAll(1);
        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
        return new ResponseEntity<Page<Post>>(posts, HttpStatus.OK);

    }

    @GetMapping(value = "/blog/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> getPost(@PathVariable("id") Long id) {
        Post post;
        post = postService.findById(id);
        if (post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<Post>(post, HttpStatus.OK);

    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Post> getDelete(@PathVariable Long id, @RequestBody Post post) {
        Post currentPost = postService.findById(id);
        if (currentPost == null) {
            return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
        }
        currentPost.setCategory(post.getCategory());
        currentPost.setContent(post.getContent());
        currentPost.setDate(post.getDate());
        currentPost.setTitle(post.getTitle());
        currentPost.setId(post.getId());
        postService.save(currentPost);
        return new ResponseEntity<Post>(currentPost, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Post> delete(@PathVariable("id") Long id) {
        Post post = postService.findById(id);
        if (post == null) {
            return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
        }
        postService.remove(id);
        return new ResponseEntity<Post>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<Page<Post>> category(@PathVariable("category")  String category){
        Page<Post> posts;
        posts = postService.findAllByTitleAndCategory("",category,1);
        if(posts == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(posts,HttpStatus.OK);

    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getCategory(){
        List<Category> category;
       category = categoryService.findAllCategory();
        if(category == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(category, HttpStatus.OK);

    }


}

