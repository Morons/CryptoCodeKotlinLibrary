# by CryptoCode

## an Library for Kotlin Users

Initial Commit only include kotlinx.datetime utils, others will follow.

[![Kotlin](https://img.shields.io/badge/kotlin-1.9.20-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Jitpack](https://jitpack.io/v/Morons/CryptoCodeKotlinLibrary.svg)](https://jitpack.io/#Morons/CryptoCodeKotlinLibrary)

### Sample time related functions

**NOTEs:**
1. use .toEpochMilliseconds() to convert to Long values
2. **ALWAYS** store dates un UCT 
3. for this demo I used `now()` (kotlinx.datetime.Clock.System.now) for Instant

* `Instant.dateTimePeriod()`=PT0.000324000S
* `nowToLongSystemDefault()`=1700058378780
* `currentMoment()`=2023-11-15T14:26:18.780031Z
* `getCurrentTimeInSeconds()`=1700058378
* `currentDayFormatted()`=2023 NOVEMBER 15
* `currentMomentUtc()`=2023-11-15T14:26:18.780062Z
* `nowToLongUtc()`=1700058378780
* `nextMonthUtc()`=2023-12-01T00:00:00Z
* `firstDayUtc()`=2023-11-01T00:00:00Z
* `lastDayUtc()`=2023-11-30T00:00:00Z
* `dateInUtc()`=2023-11-15
* `in30DaysUtc()`=2023-12-15T14:26:18.780031Z
* `past15DaysUtc()`=2023-10-31T14:26:18.780031Z
* `past60DaysUtc()`=2023-09-16T14:26:18.780031Z
* `inXDaysUtc(days = 20)`=2023-12-05T14:26:18.780031Z
* `pastXDaysUtc(days = 20)`=2023-10-26T14:26:18.780031Z
* `String?.splitToStrings(delimiter: Char = ','): List<String>` Inverse of Kotlin `List<String>.joinToString()`
* `fun <T> Gson.fromJsonOrNull(json: String, clazz: Class<T>): T?`  To convert json to classes
* `fun String.isValidJson(): Boolean` To test if a json is valid
* `getResourceProperty()` get a property value from resource file
* `setResourceProperty()` set a property value in resource file

P.S. Request more Utilities if you need.

## Configuration

### Gradle - Kotlin

In your root build.gradle.kts

```
dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		mavenCentral()
		maven("https://jitpack.io")
	}
}
```
add the dependency
```
dependencies {
	implementation("com.github.Morons:CryptoCodeKotlinLibrary:1.0.2")
}
```