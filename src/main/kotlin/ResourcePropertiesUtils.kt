import java.io.*
import java.util.*

object ResourcePropertiesUtils {
	/**
	 * This function retrieves a string from a system properties file
	 * @param key the Key name to retrieve
	 * @param fileName (defaulted to "version.properties")
	 **/
	fun getResourceProperty(
		key: String,
		fileName: String = "version.properties"
	): String? {
		val properties = Properties()

		// get class loader
		var loader: ClassLoader? = ResourcePropertiesUtils::class.java.getClassLoader()
		if (loader == null) loader = ClassLoader.getSystemClassLoader()

		// assuming you want to load application.properties located in WEB-INF/classes/conf/
		val url = loader?.getResource("")

		val realPath = Thread.currentThread().getContextClassLoader().getResource("")?.path
//		val rootPath = realPath.
		val localProperties = File("$realPath$fileName")
		println("getResourceProperty.localProperties = $localProperties")
		println("getResourceProperty.url = $url")
		if (localProperties.isFile) {
			InputStreamReader(FileInputStream(localProperties), Charsets.UTF_8).use { reader ->
				properties.load(reader)
			}
		} else {
			properties.setProperty("MAJOR", "0")
			properties.setProperty("MINOR", "0")
			properties.setProperty("VERSION_CODE", "1")
			properties.setProperty("PATCH", "0")
			OutputStreamWriter(FileOutputStream(localProperties), Charsets.UTF_8).use { fileOutputStream ->
				properties.store(fileOutputStream, null)
			}
		}
		return properties.getProperty(key)
	}

	/**
	 * This function retrieves a string from a system properties file
	 * @param key the Key name to retrieve
	 * @param value the value to be set as a string
	 * @param fileName (defaulted to "version.properties")
	 **/
	fun setResourceProperty(
		key: String,
		value: String,
		fileName: String = "version.properties"
	) {
		val properties = Properties()
		val rootPath = Thread.currentThread().getContextClassLoader().getResource("")?.path
		val localProperties = File("$rootPath$fileName")
		println("setResourceProperty.localProperties = $localProperties")
		if (localProperties.isFile) {
			println("Using existing properties file")
			InputStreamReader(FileInputStream(localProperties), Charsets.UTF_8).use { reader ->
				properties.load(reader)
			}
			properties.setProperty(key, value)
			OutputStreamWriter(FileOutputStream(localProperties), Charsets.UTF_8).use { fileOutputStream ->
				properties.store(fileOutputStream, null)
			}
		} else {
			println("Creating new properties file")
			properties.setProperty("MAJOR", "0")
			properties.setProperty("MINOR", "0")
			properties.setProperty("VERSION_CODE", "1")
			properties.setProperty("PATCH", "0")
			properties.setProperty(key, value)
			OutputStreamWriter(FileOutputStream(localProperties), Charsets.UTF_8).use { fileOutputStream ->
				properties.store(fileOutputStream, null)
			}
		}
	}
}