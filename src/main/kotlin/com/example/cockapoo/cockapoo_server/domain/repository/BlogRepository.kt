

import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface BlogRepository : JpaRepository<Blog, Long> {
    fun findByTitle(title: String): Blog?
}