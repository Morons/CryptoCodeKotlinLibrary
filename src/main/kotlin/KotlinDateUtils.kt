import kotlinx.datetime.*
import kotlinx.datetime.Clock.System.now
import kotlin.time.Duration
import kotlin.time.Duration.Companion.days

private const val MILLIS_IN_A_SECOND: Int = 1000

private val currentMoment: Instant = now()  // Current Clock time of Device
private val currentMomentUtc: Instant = now()

//private val currentMomentUtc: Instant = currentMoment.toLocalDateTime(TimeZone.UTC).toInstant(TimeZone.UTC)
private val datetimeInUtc: LocalDateTime = currentMoment.toLocalDateTime(TimeZone.UTC)
private val dateInUtc: LocalDate = datetimeInUtc.date
private val datetimeInSystemZone: LocalDateTime = currentMoment.toLocalDateTime(TimeZone.currentSystemDefault())
private val monthNumber: Int = dateInUtc.monthNumber
private val dayOfMonthNumber: Int = dateInUtc.dayOfMonth
private val yearNumber: Int = dateInUtc.year
private val time: LocalTime = datetimeInUtc.time
private val firstDayUtc: Instant = Instant.parse(
	isoString = "${yearNumber.toString().padStart(length = 4, padChar = '0')}-${
		monthNumber.toString().padStart(length = 2, padChar = '0')
	}-01T00:00:00Z"
)
private val nextMonth: Instant = firstDayUtc.plus(value = 1, unit = DateTimeUnit.MONTH, timeZone = TimeZone.UTC)
private val lastDay: Instant = nextMonth.minus(value = 1, unit = DateTimeUnit.DAY, timeZone = TimeZone.UTC)
private val durationToNextMonth: Duration = nextMonth - currentMoment
fun Instant.dateTimePeriod(): DateTimePeriod = this.periodUntil(now(), TimeZone.UTC)
fun nowToLongSystemDefault(): Long =
	datetimeInSystemZone.toInstant(TimeZone.currentSystemDefault()).toEpochMilliseconds()

fun currentMoment() = currentMoment
fun getCurrentTimeInSeconds(): Int = currentMomentUtc().epochSeconds.toInt()
fun currentDayFormatted() =
	with(currentMoment().toLocalDateTime(TimeZone.currentSystemDefault())) { "$year $month $dayOfMonth" }

fun currentMomentUtc() = currentMomentUtc
fun nowToLongUtc(): Long = datetimeInUtc.toInstant(TimeZone.UTC).toEpochMilliseconds()
fun nextMonthUtc() = currentMoment + durationToNextMonth
fun firstDayUtc() = firstDayUtc
fun lastDayUtc() = lastDay
fun dateInUtc() = dateInUtc
fun in30DaysUtc() = datetimeInUtc.toInstant(TimeZone.UTC) + 30.days
fun inXDaysUtc(days: Int) = datetimeInUtc.toInstant(TimeZone.UTC) + days.days
fun past15DaysUtc() = (datetimeInUtc.toInstant(TimeZone.UTC) - 15.days)
fun past60DaysUtc() = (datetimeInUtc.toInstant(TimeZone.UTC) - 60.days)
fun pastXDaysUtc(days: Int) = (datetimeInUtc.toInstant(TimeZone.UTC) - days.days)