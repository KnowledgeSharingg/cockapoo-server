
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import org.jsoup.Jsoup
import org.springframework.transaction.annotation.Transactional
import org.springframework.stereotype.Service

@Service
class BlogService(private val blogRepository: BlogRepository) {

    fun getBlogs(): List<Blog> = blogRepository.findAll()

    fun updateBlogsFromGithubRepository() {
        val blogs = _getBlogsFromGithubRepository()
        blogRepository.saveAll(blogs)
    }

    @Transactional
    private fun _getBlogsFromGithubRepository(): List<Blog> {
        val URL = "https://github.com/seongkyu-lim/TechBlogs"
        val doc: Document = Jsoup.connect(URL).get()
        val elements: Elements = doc.select("p[dir=auto]")

        return elements.chunked(2)
            .filter { chunk -> 
                chunk.size == 2 && blogRepository.findByTitle(chunk[0].text()) == null
            }
            .map { chunk -> 
                // Blog().apply {
                //     title = chunk[0].text()
                //     link = chunk[1].text()
                // }
                Blog(
                    title = chunk[0].text(),
                    link = chunk[1].text(),
                    content = "content",
                    author = "author"
                )
            }
    }
}