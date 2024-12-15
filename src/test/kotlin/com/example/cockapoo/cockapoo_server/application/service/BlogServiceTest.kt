import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.mockk
import io.mockk.every

class BlogServiceTest: BehaviorSpec({
    val blogRepository = mockk<BlogRepository>()
    val blogService = BlogService(blogRepository)

    context("i can get blogs") {
        given("blogs") {
            every { blogRepository.findAll() } returns listOf(
                Blog(id = 1, title = "Test Blog 1", content = "1 content", author = "1 author", link = ""),
                Blog(id = 2, title = "Test Blog 2", content = "2 content", author = "2 author", link = ""),
            )
            `when`("i request get blogs") {
                val result = blogService.getBlogs()
                then("i can get blogs") {
                    assert(result is List<Blog>) { "Result is not a List" }
                }
            }
        }
    }
})