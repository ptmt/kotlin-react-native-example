package index

import react.*
import reactnative.*
import app.*

fun run() = { App()}
fun main(args: Array<String>) {
  AppRegistry.registerComponent("kotlinchat") {
    run()
  }
}
