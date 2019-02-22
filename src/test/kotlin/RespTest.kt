package resp

import org.junit.Assert.assertEquals
import org.junit.Test

class RespTest {
    @Test
    fun testEncodeString() {
        assertEquals(Resp().encodeString("test"), "+test\r\n")
    }

    @Test
    fun testEncodeError() {
        assertEquals(Resp().encodeError("ERROR"), "-ERROR\r\n")
    }

    @Test
    fun testEncodeInt() {
        assertEquals(Resp().encodeInt(88), ":88\r\n")
    }

    @Test
    fun testEncodeBulkString() {
        assertEquals(Resp().encodeBulkString("test"), "$4\r\ntest\r\n")
    }

    @Test
    fun testEncodeNull() {
        assertEquals(Resp().encodeNull(), "$-1\r\n")
    }

    @Test
    fun testEncodeNullArray() {
        assertEquals(Resp().encodeNullArray(), "*-1\r\n")
    }

    @Test
    fun testEncodeArray() {
        assertEquals(Resp().encodeArray(arrayOf(Resp().encodeInt(1))), "*1\r\n:1\r\n")
    }

    @Test
    fun testEncodeRequest() {
        assertEquals(Resp().encodeRequestArray(arrayOf("LLEN", "mylist")) , "*2\r\n$4\r\nLLEN\r\n$6\r\nmylist\r\n")
    }
}
