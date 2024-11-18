package com.web.fitquest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.fitquest.model.category.Category;
import com.web.fitquest.service.category.CategoryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/category")
@Slf4j
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getCategoryList(@PathVariable int userId) {
        try {
            Optional<List<Category>> opCategoryList = categoryService.getCategoryList(userId);
            return opCategoryList.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("서버 오류 발생");
        }
    }
}
