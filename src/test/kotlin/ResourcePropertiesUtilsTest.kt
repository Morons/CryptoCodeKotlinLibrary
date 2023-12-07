import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ResourcePropertiesUtilsTest {
	@Test
	fun getResourcePropertyTest() {
		setResourceProperty(key = "PATCH", value = "777")
		val expected = "777"
		val property = getResourceProperty(key = "PATCH") ?: ""
		assertEquals(expected = expected, property)
	}
}