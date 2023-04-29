package com.alan.cockapooserver.blog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    public List<Blog> getBlogList(){
        return blogRepository.findAll();
    }

    public void saveBlogList() {
        // TODO : tech blogs 레포로 부터 블로그 리스트 저장 혹은 업데이트.

    }
}
