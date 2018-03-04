package app.messages
import kotlin.js.Date
/* interface Message {
    var text: String
} */

val user = object {
  val _id = "2"
  val identity = "identity2"
  val avatar = "https://api.adorable.io/avatars/99/user2@adodfdrable.io.png"
}

data class Message(val _id: String, val text: String, val user: Any, val createdAt: Any)

fun generateMessages(): Array<Message> {
  val array = Array(5, { i -> Message(i.toString(), "Some random message no $i", user, Date.now()) })
  console.log(array)
  return array
}
