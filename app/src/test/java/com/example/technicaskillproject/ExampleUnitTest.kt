package com.example.technicaskillproject

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.technicaskillproject.model.Data
import com.example.technicaskillproject.model.Result
import com.example.technicaskillproject.viewmodel.MyViewModel
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.mockito.Mockito
import java.util.concurrent.Callable

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    lateinit var some: MyViewModel

    @Before
    fun init() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler: Callable<Scheduler?>? -> Schedulers.trampoline() }
        some = Mockito.mock(MyViewModel::class.java)
    }

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `Test the getData Function`() {
        val list = arrayListOf<Result>(
            Result(
                true, "1.12.2001", 200, "someImage", 20,
                20,
                "20", 5.6, "1.1.2000", "SomeSynopsis", "ANIME", "type", "URL"
            ),
            Result(
                true, "1.12.20021", 200, "someImage", 20,
                20,
                "20", 5.6, "1.1.24000", "SomeSynopsis2", "ANIM4E", "t2ype", "UR3L"
            ),
            Result(
                true, "1.12.2301", 200, "someImage", 20,
                20,
                "20", 5.6, "1.1.2000", "SomeSynopsisd", "AN4IME", "typ1e", "UR4L"
            ),
            Result(
                true, "1.12.20501", 200, "someImage", 20,
                20,
                "20", 5.6, "1.1.21000", "SomeSynopsis", "ANI4ME", "type1", "U5RL"
            )
        )
        val data = Data(
            1, 23, true, "123123", list
        )

        val single = Single.just(data)

        Mockito.`when`(some.getData("naruto")).thenReturn(single)

        Mockito.`when`(some.passData("naruto")).thenCallRealMethod()

        some.passData("naruto").observeForever {
            if (!it.isNullOrEmpty()) {
                assertEquals(it, list)
            }
        }
    }
}