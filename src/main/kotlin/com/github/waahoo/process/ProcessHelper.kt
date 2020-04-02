package com.github.waahoo.process

import java.io.BufferedReader

import java.io.InputStream
import java.io.InputStreamReader


object ProcessHelper {
  
  fun run(vararg command: String) {
    val process = ProcessBuilder(*command)
    process.inheritIO().start().waitFor()
  }
  
  fun call(vararg command: String): String {
    val builder = ProcessBuilder(*command)
    builder.redirectErrorStream(true)
    val process: Process = builder.start()
    val input: InputStream = process.inputStream
    val reader = BufferedReader(InputStreamReader(input))
    reader.use {
      return it.readText()
    }
  }
}