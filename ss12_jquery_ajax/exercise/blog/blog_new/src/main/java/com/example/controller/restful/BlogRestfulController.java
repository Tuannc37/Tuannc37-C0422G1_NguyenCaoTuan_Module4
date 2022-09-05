package com.example.controller.restful;

import com.example.model.Blog;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("blog/api")
public class BlogRestfulController {

    @Autowired
    private IBlogService service;

    @GetMapping("")
    public ResponseEntity<Page<Blog>> findAll(@PageableDefault(page = 0, size = 5) Pageable pageable,
                                     @RequestParam Optional<String> name){
        String nameVal = name.orElse("");
        Page<Blog> blogPage = service.findAllByNameBlog(nameVal, pageable);
        if(blogPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(blogPage, HttpStatus.OK);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> createBlog(@RequestBody Blog blog){
        return new ResponseEntity<>(service.save(blog), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id , @RequestBody Blog blog){
        Optional<Blog> blogOptional = service.findId(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(blogOptional.get().getId());
        return new ResponseEntity<>(service.save(blog), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id ){
        Optional<Blog> blogOptional = service.findId(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        Optional<Blog> blogOptional = service.findId(id);
        if(!blogOptional.isPresent()){
            return new ResponseEntity<>(blogOptional, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogOptional, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Blog>> showListBlogInCategory(@PathVariable("id") Integer id){
        List<Blog> blogList = service.findAllByCategory(id);
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
}
