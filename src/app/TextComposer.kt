package app.textcomposer

import react.*
import reactnative.chat.Composer

interface Props: RProps {
  var onTextChanged: dynamic
  var text: String
}

class TextComposer(props: Props): RComponent<Props, RState>(props) {
    override fun RBuilder.render() {
      Composer {
          // attrs = props
          attrs.onTextChanged = props.onTextChanged
          attrs.textInputStyle = object {
            val paddingHorizontal = 16
            val justifyContent = "center"
            val alignItems = "center"
            val backgroundColor = "rgba(250, 250, 250, 0.9)"
            val borderStyle = "solid"
            val borderWidth = 1
            val marginLeft = 10
            val marginRight = 0
            val minHeight = 36
            val fontSize = 16
            val lineHeight = 24
            val borderColor = "#c7d8de"
            val paddingVertical = 6
         }
         attrs.text = props.text
      }
    }
}

fun RBuilder.textComposer(props: dynamic) = child(TextComposer::class) {
  attrs.onTextChanged = props.onTextChanged
  attrs.text = props.text
}
