package com.blog_webservice.service.impl;
import com.blog_webservice.model.Post;
import com.blog_webservice.repository.PostRepository;
import com.blog_webservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;

    @Override
    public Page<Post> findAll(int page) {
        Pageable pageable = PageRequest.of(page-1,2, Sort.by("date").ascending());
        return postRepository.findAll(pageable);
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void remove(Long id) {
        postRepository.deleteById(id);

    }

    @Override
    public Page<Post> findAllByTitleAndCategory(String title, String category, int page) {
        Pageable pageable = PageRequest.of(page-1,3, Sort.by("date").ascending());
        return postRepository.findAllByTitleContainingAndCategory_NameContaining(title,category,pageable);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
