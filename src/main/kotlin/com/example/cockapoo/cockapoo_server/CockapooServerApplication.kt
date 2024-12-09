package com.example.cockapoo.cockapoo_server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import io.sentry.spring.jakarta.EnableSentry
import org.springframework.core.Ordered

@EnableSentry(
  dsn = "https://dd648c43ed4002ece0303dc51fbf07b8@o4508437281832960.ingest.us.sentry.io/4508437284061184",
  exceptionResolverOrder = Ordered.LOWEST_PRECEDENCE
)
@SpringBootApplication
class CockapooServerApplication

fun main(args: Array<String>) {
	runApplication<CockapooServerApplication>(*args)
}
