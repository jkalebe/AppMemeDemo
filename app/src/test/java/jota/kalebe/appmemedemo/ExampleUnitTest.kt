package jota.kalebe.appmemedemo

import jota.kalebe.appmemedemo.model.MemeHttp
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val list = MemeHttp.loadList()
        list?.data?.memes?.forEach {
                meme ->
            println(meme)
        }
        println("Tamanho da lista: " + list?.data?.memes?.size)
    }
}