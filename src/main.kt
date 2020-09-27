import java.time.LocalDate
import java.time.format.DateTimeFormatter
//import java.time.temporal.ChronoUnit
import java.util.*

fun main(){
    val formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")
    val year: Int = Calendar.getInstance().get(Calendar.YEAR)
    val today = LocalDate.now()
    val formattedToday = today.format(formatter)
    // the last full moon was on sept 1 2020 at 10:23:12 PM
    val lastFullMoonMonth = 9
    val lastFullMoonDay = 1
    val lastFullMoonHours = 22
    val lastFullMoonMinutes = 23
    val lastFullMoon: LocalDate = LocalDate.of(year, lastFullMoonMonth, lastFullMoonDay)
    val formattedLastFullMoon = lastFullMoon.format(formatter)



    var nextFullMoon = lastFullMoon
// moon takes 29 days 12 hours 44 minutes to get new full moon
// if last full moon was after 11:16 AM, add 30 days instead of 29
    if (lastFullMoonHours > 11){
        nextFullMoon = nextFullMoon.plusDays(30)
    }
    else if (lastFullMoonHours == 11){
        if (lastFullMoonMinutes > 16){
            nextFullMoon = nextFullMoon.plusDays(30)
        }
        else {
            nextFullMoon = nextFullMoon.plusDays(29)
        }
    }
    else {
        nextFullMoon = nextFullMoon.plusDays(29)
    }
    val formattedNextFullMoon = nextFullMoon.format(formatter)

    print("today's date is: ")
    println(formattedToday)

    print("the last full moon was: ")
    println(formattedLastFullMoon)

    print("the next full moon will be: ")
    println(formattedNextFullMoon)
}