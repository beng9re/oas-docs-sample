package org.example.oaspublish

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api-docs")
class ApiDocController {

    @GetMapping("{path}")
    fun getApiDocs(@PathVariable("path") path: String): String = path
}
