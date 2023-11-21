import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ResourcePropertiesUtilsTest {

	@Test
	fun getResourceProperty() {
		setResourceProperty(
			key = "greeting",
			value = "Hello World",
			filePath = "src/main/resources/",
			fileName = "test.properties"
		)
		val expected = "Hello World"
		val property = getResourceProperty(
			key = "greeting",
			filePath = "src/main/resources/",
			fileName = "test.properties"
		) ?: ""
		assertEquals(expected = expected, property)
	}
}