package app.sendbutton

import react.*
import reactnative.*

interface SendButtonProps: RProps {
  var onSend: dynamic
  var text: String
}

val styles = object {
  val paddingHorizontal = 6
  val justifyContent = "center"
  val alignItems = "center"
  val height = 44
}

class SendButton(props: SendButtonProps): RComponent<SendButtonProps, RState>(props) {
    private fun _onSend() {
        console.log("onSend", props)
        val payload = object {
          val body = props.text
        }
        props.onSend(payload, true)
    }

    override fun RBuilder.render() {
          View {
            attrs {
              style = styles
            }
            Button {
              attrs {
                title = "Send"
                onPress = { _onSend() }
              }
            }
          }
    }
}

fun RBuilder.sendButton(props: dynamic) = child(SendButton::class) {
   attrs.onSend = props.onSend
   attrs.text = props.text
}
