import com.azabost.quest.time.api.NowProvider

class FakeNowProvider(initialNow: Long = System.currentTimeMillis()) : NowProvider {

    private var now = initialNow

    override fun now(): Long = now

    fun advanceTimeBy(millis: Long) {
        now += millis
    }
}