package sample

import game
import react.dom.div
import react.dom.render
import kotlin.browser.*

actual class Sample {
    actual fun checkMe() = 12
}

actual object Platform {
    actual val name: String = "JS"
}

fun helloWorld(salutation: String) {
    val message = "$salutation from Kotlin.JS ${hello()}, check me value: ${Sample().checkMe()}"
    val elementById = document.getElementById("js-response")
    elementById?.textContent = message
    render(elementById){
        game(message)
    }
}

fun main() {
    helloWorld(":) Hi!")
}