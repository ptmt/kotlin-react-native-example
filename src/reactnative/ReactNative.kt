@file:JsModule("react-native")

package reactnative

import react.*

external interface ViewProps : RProps {
  var children: List<Any>
  var style: dynamic
}

external interface ButtonProps: RProps {
  var title: String
  var onPress: () -> Unit
}

external val View: RClass<ViewProps>
external val Text: RClass<ViewProps>
external val Button: RClass<ButtonProps>

external object AppRegistry {
  fun registerComponent(appKey: String, getComponentFunc: () -> Any)
}
