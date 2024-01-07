package com.alan.cockapooserver.blog;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static com.alan.cockapooserver.global.Response.responseCreated;
import static com.alan.cockapooserver.global.Response.responseOKWith;

@RestController()
@RequestMapping("/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping()
    public ResponseEntity<?> getBlogList(){
        return ResponseEntity.ok().body(responseOKWith(blogService.getBlogList()));
    }

    @PostMapping()
    public ResponseEntity<?> updateBlogListFromRepo() throws IOException {
        blogService.updateBlogList();
        return ResponseEntity.created(null).body(responseCreated());
    }
}
