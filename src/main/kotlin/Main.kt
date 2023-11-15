import kotlinx.datetime.Clock

fun main(args: Array<String>) {
	println("Instant.dateTimePeriod()=${Clock.System.now().dateTimePeriod()}")
	println("nowToLongSystemDefault()=${nowToLongSystemDefault()}")
	println("currentMoment()=${currentMoment()}")
	println("getCurrentTimeInSeconds()=${getCurrentTimeInSeconds()}")
	println("currentDayFormatted()=${currentDayFormatted()}")
	println("currentMomentUtc()=${currentMomentUtc()}")
	println("nowToLongUtc()=${nowToLongUtc()}")
	println("nextMonthUtc()=${nextMonthUtc()}")
	println("firstDayUtc()=${firstDayUtc()}")
	println("lastDayUtc()=${lastDayUtc()}")
	println("dateInUtc()=${dateInUtc()}")
	println("in30DaysUtc()=${in30DaysUtc()}")
	println("inXDaysUtc(days = 20)=${inXDaysUtc(days = 20)}")
	println("past15DaysUtc()=${past15DaysUtc()}")
	println("past60DaysUtc()=${past60DaysUtc()}")
	println("pastXDaysUtc(days = 20)=${pastXDaysUtc(days = 20)}")
}