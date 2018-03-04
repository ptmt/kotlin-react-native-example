@file:JsModule("react-native-gifted-chat-flat")

package reactnative.chat

import react.*

external interface ViewProps : RProps {
  var children: List<Any>
  var style: Any
  var renderSend: dynamic
  var onInputTextChanged: dynamic
  var inputContainerStyle: dynamic
  var renderComposer: dynamic
  var messages: dynamic
  var primaryStyle: dynamic
  var user: dynamic
  var onSend: dynamic
}

external interface ComposerProps: RProps {
  var textInputStyle: dynamic
  var onTextChanged: dynamic
  var text: String
}


external val GiftedChat: RClass<ViewProps>
external val Composer: RClass<ComposerProps>
