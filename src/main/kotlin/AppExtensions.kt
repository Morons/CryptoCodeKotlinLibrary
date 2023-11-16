
/**
 * Inverse of Kotlin List<String>.joinToString()
 * @param delimiter the character used to split defaulted to ','
 **/
fun String?.splitToStrings(delimiter: Char = ','): List<String> =

	if (this?.isNotEmpty() == true) {
		split(delimiter).map { it.trim() }
	} else emptyList()