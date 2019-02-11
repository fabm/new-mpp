package sample

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.html.respondHtml
import io.ktor.routing.get
import io.ktor.routing.routing
import kotlinx.html.*

actual class Sample {
    actual fun checkMe() = 42
}

actual object Platform {
    actual val name: String = "JVM"
}

fun Application.main() {
    routing {
        get("/") {
            call.respondHtml {
                head {
                    link(href = "/styles.css", rel = "styleSheet", type = "text/css")

                }
                body {
                    div(classes = "container pt-3") {
                        div(classes = "card-deck mb-2 text-center") {
                            div(classes = "card mb-4 shadow-sm") {
                                div(classes = "card-header") {
                                    h4 { +"client rendering" }
                                }
                                div(classes = "card-body") {
                                    id = "js-response"
                                    +"loading..."
                                }
                            }
                            div(classes = "card mb-4 shadow-sm") {
                                div(classes = "card-header") {
                                    h4 { +"server rendering" }
                                }
                                div(classes = "card-body") {
                                    +"${hello()} from Ktor. Check me value: ${Sample().checkMe()}"
                                }
                            }
                        }
                    }
                    script(src = "/main.bundle.js") {
                    }
                }
            }
        }
    }
}
