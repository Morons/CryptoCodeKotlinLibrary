import com.google.gson.Gson
import com.google.gson.JsonParser
import com.google.gson.JsonSyntaxException

/**
 *  De-serialise json to a data class
 **/
fun <T> Gson.fromJsonOrNull(json: String, clazz: Class<T>): T? {
	if (!json.isValidJson()) return null
	return try {
		fromJson(json, clazz)
	} catch (e: JsonSyntaxException) {
		null
	}
}

/**
 * Test if a json String can be parsed into a tree of JsonElements.
 **/
fun String.isValidJson(): Boolean {
	try {
		JsonParser.parseString(this)
	} catch (e: JsonSyntaxException) {
		return false
	}
	return true
}