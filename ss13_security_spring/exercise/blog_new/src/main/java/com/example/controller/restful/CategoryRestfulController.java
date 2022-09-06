package com.example.controller.restful;

import com.example.model.Category;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category/api")
public class CategoryRestfulController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public ResponseEntity<Page<Category>> findAllCategory(@PageableDefault(page = 0, size = 5) Pageable pageable){
        Page<Category> categoryList = iCategoryService.findAllCategory(pageable);
        if(categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(categoryList, HttpStatus.OK);
        }
    }

}
