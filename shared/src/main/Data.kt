package data.messages
import platform.Foundation.*

val user2 = object {
  val _id = "2"
  val identity = "identity2"
  val avatar = "https://api.adorable.io/avatars/99/user2@adodfdrable.io.png"
}

val user = mapOf ("_id" to 2, "identity" to "idenity2", "avatar" to "https://api.adorable.io/avatars/99/user2@adodfdrable.io.png")

data class Message(val _id: String, val text: String, val user: Any, val createdAt: Any)

fun generateMessage(id: Int): Map<String, Any> {
  var message = emptyMap<String, Any>().toMutableMap()
  message.put("_id", id.toString())
  message.put("text", "Some random message no $id")
  message.put("user", user)
  message.put("createdAt", NSDate.date())
  return message.toMap()
}

fun generateMessages(number: Int): List<Any> {
  val array = List(number, {i -> generateMessage(i) })
  return array
}
