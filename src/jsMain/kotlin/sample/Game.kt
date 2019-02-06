import kotlinx.html.js.onClickFunction
import react.*
import react.dom.div


class Game(props: Props): RComponent<Game.Props, Game.State>(props) {
    interface Props: RProps {
        var text: String
    }
    interface State: RState {
        var text: String
    }

    override fun State.init(props: Props) {
        text = props.text
    }

    override fun RBuilder.render() {
        div(classes = "cool") {
            attrs.onClickFunction = {
                setState {
                    text = "already"
                }
                println("clicked !!!")
            }
            +"[${state.text}]"
        }

    }

}

fun RBuilder.game(text:String) = child(Game::class) {
    attrs.text = text
}
