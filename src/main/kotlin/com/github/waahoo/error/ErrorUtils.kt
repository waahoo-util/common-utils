package com.github.waahoo.error

import java.io.ByteArrayOutputStream
import java.io.PrintStream

fun Exception.stackTraceToString(): String {
  val bout = ByteArrayOutputStream()
  bout.use {
    printStackTrace(PrintStream(bout, true, "UTF-8"))
  }
  return bout.toString("UTF-8")
}