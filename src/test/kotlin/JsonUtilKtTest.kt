import com.google.gson.Gson
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class JsonUtilKtTest {

	private val gson = Gson()

	private val jsonString = "{\"greeting\": \"Hello World\"}"

	@Test
	fun fromJsonOrNull() {
		val expected =  "Hello World"
		val jsonTest = gson.fromJsonOrNull(jsonString, JsonTest::class.java)
		assertEquals(expected = expected, actual = jsonTest?.greeting ?: "")
	}

	@Test
	fun isValidJson() {
		jsonString.isValidJson()
	}
}

class JsonTest(
	val greeting: String
)