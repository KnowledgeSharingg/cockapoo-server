

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@RestController
@RequestMapping("blog")
class BlogController(private val blogService: BlogService) {

    @GetMapping()
    fun getBlogs() = blogService.getBlogs()

    @PostMapping()
    fun updateBlogsFromGithubRepository() = blogService.updateBlogsFromGithubRepository()
}