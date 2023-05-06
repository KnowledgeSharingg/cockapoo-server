package com.alan.cockapooserver.blog;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    public List<Blog> getBlogList(){
        return blogRepository.findAll();
    }

    @Transactional
    public void updateBlogList() throws IOException {

        List<Blog> blogs = new ArrayList<>();

        String URL = "https://github.com/seongkyu-lim/TechBlogs";
        Document doc = Jsoup.connect(URL).get();
        Elements elements = doc.select("p[dir=auto]");

        for (int i=0; i<elements.size()-1; i+=2) {
            if(blogRepository.findByName(elements.get(i).text()).isPresent()) continue;
            Blog blog = new Blog();
            blog.setName(elements.get(i).text());
            blog.setUrl(elements.get(i+1).text());
            blogs.add(blog);
        }
        blogRepository.saveAll(blogs);
    }
}
