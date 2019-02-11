import kotlinx.html.js.onClickFunction
import react.*
import react.dom.a


class Game(props: Props) : RComponent<Game.Props, Game.State>(props) {
    private var i = 0

    interface Props : RProps {
        var text: String
    }

    interface State : RState {
        var text: String
    }

    override fun State.init(props: Props) {
        text = props.text
    }

    override fun RBuilder.render() {
        a(href = "#", classes = "btn btn-primary") {
            attrs.onClickFunction = {
                setState {
                    text = "already${i++}"
                }
                println("clicked !!!")
            }
            +"${state.text}"
        }
    }

}

fun RBuilder.game(text: String) = child(Game::class) {
    attrs.text = text
}
