package com.alan.cockapooserver

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CockapooController {
    @GetMapping("health-check")
    fun healthCheck(): String {
        return "I\'m healthy!"
    }
}