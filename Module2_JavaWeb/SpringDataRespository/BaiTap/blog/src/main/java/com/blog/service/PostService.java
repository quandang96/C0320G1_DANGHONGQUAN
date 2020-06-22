package com.blog.service;

import com.blog.model.Category;
import com.blog.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
Page<Post> findAll(int page);
Post findById(Long id);
void save(Post post);
void remove(Long id);
Page<Post> findAllByTitleAndCategory(String title, String category, int page);
List<Post> findAll();

}
