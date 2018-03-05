package app

import kotlin.js.Date
import react.*
import reactnative.*
import reactnative.chat.*
import app.sendbutton.*
import app.textcomposer.*
import app.messages.*

interface AppState : RState {
    var messages: Array<Message>
}

val currentUser = object {
  val _id = "1"
  val identity = "user1"
  val avatar = "https://api.adorable.io/avatars/99/user2@adodfdrable.io.png"
}

class App: RComponent<RProps, AppState>() {
    override fun AppState.init() {
      // TODO: is there any way to handle Promises nicer? like that https://github.com/mplatvoet/kovenant
      generateMessages(5).then { m: Array<Message> ->
        console.log("generatedMessages", m)
        messages = m
      }
    }
    private fun _onInputTextChanged(s: String) {
      console.log("_onInputTextChanged:", s)
    }
    private fun onMessageSend(messagesToSent: Array<dynamic>) {
      val newMessage = Message(state.messages.size.toString(), messagesToSent[0].body, currentUser, Date.now())
      setState {
        // [newElement, ...oldList] in js
        messages = messages.reversedArray().plus(newMessage).reversedArray()
      }
    }
    override fun RBuilder.render() {
        View {
          attrs.style = object {
            val backgroundColor = "#f9f9f9"
            val position = "absolute"
            val top = 0
            val bottom = 0
            val left = 0
            val right = 0
            val flex = 1
          }
          GiftedChat {
            attrs {
              renderSend = { props: dynamic -> sendButton(props) }
              onInputTextChanged = { e: String -> _onInputTextChanged(e) }
              inputContainerStyle = object {
                val borderTopWidth: Int = 0
                val alignItems: String = "center"
              }
              renderComposer = { props: dynamic -> textComposer(props) }
              messages = state.messages
              primaryStyle = object {
                val backgroundColor = "#f9f9f9"
                val borderWidth = 0
                val alignItems = "center"
              }
              user = currentUser
              onSend = { m: Array<Message> -> onMessageSend(m)}
            }
          }
        }

    }
}
