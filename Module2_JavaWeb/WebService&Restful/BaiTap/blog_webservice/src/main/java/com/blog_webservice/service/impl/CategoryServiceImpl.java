package com.blog_webservice.service.impl;
import com.blog_webservice.model.Category;
import com.blog_webservice.repository.CategoryRepository;
import com.blog_webservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
@Autowired
private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }
}
