package resp

const val CRLF = "\r\n"

class Resp {
  fun encodeString (str: String): String {
    return "+$str$CRLF"
  }
}
