package resp

import org.junit.Assert.assertEquals
import org.junit.Test

class RespTest {
    @Test fun testEncodeString() {
        assertEquals(Resp().encodeString(("test")), "+test\r\n")
    }
}
