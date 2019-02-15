package resp

const val CRLF = "\r\n"

class Resp {
  fun encodeString (str: String): String {
    return "+${str}${CRLF}"
  }

  fun encodeError (errorMessage: String): String {
    return "-${errorMessage}${CRLF}"
  }

  fun encodeInt (int: Int): String {
    return ":${int}${CRLF}"
  }

  fun encodeBulkString (bulkString: String): String {
    return "$${bulkString.length}${CRLF}${bulkString}${CRLF}"
  }

  fun encodeNull (): String {
    return "$-1${CRLF}"
  }

  fun encodeNullArray (): String {
    return "*-1${CRLF}"
  }
}
