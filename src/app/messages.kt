package app.messages

import kotlin.js.Promise
import reactnative.NativeModules

data class Message(val _id: String, val text: String, val user: Any, val createdAt: Any)

fun generateMessages(number: Int): Promise<Array<Message>> = NativeModules.SharedDataModule.generateMessages(number)
