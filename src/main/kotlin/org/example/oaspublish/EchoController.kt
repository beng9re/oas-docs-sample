package org.example.oaspublish

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag
import org.springdoc.core.annotations.ParameterObject
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Schema(description = "에코 요청")
@ParameterObject
data class EchoRequest(
    @Parameter(description = "요청 이름") val text: String,
    @Parameter(description = "요청 상세") val description: String
)

@Schema(description = "에코 응답")
data class EchoResponse(
    @Schema(description = "응답 이름")
    val text: String,
    @Schema(description = "응답 상세")
    val description: String
)

@RestController
@Tag(name = "에코 응답")
@RequestMapping("/echo")
class EchoController {

    @GetMapping("/")
    @Operation(summary = "응답 요청", description = "응답")

    fun getEcho(
        echoRequest: EchoRequest
    ): EchoResponse {
        return EchoResponse(
            text = echoRequest.text,
            description = echoRequest.description
        )
    }
}
