package com.example.lesson

import android.util.Log
import android.widget.Toast
import com.example.core.http.EntityCallback
import com.example.core.http.HttpClient
import com.example.core.http.HttpClient.get
import com.example.core.utils.Utils
import com.example.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken
import java.util.*
import kotlin.collections.ArrayList

/**
 *
 * @Description:     java类作用描述
 * @Author:          lee
 * @CreateDate:     2020/9/7 3:57 PM
 */
class LessonPresenter {


    private var activity: LessonActivity? = null

    companion object {
        const val LESSON_PATH = "lessons"
    }

    constructor(activity: LessonActivity) {
        this.activity = activity
    }


    private var lessons: List<Lesson> = ArrayList()
    private val type = object : TypeToken<List<Lesson>>() {}.type

    fun fetchData() {
        get(LESSON_PATH, type, object : EntityCallback<List<Lesson>> {
            override fun onSuccess(entity: List<Lesson>) {
                this@LessonPresenter.lessons = entity
                activity!!.runOnUiThread {
                    activity!!.showResult(entity)
                }
                Log.e("TAG",entity.toString())
            }

            override fun onFailure(message: String?) {
                activity!!.runOnUiThread {
                    Utils.toast(message)
                }
            }
        })
    }

    fun showPlayback() {
        activity!!.showResult(lessons.filter {  it.state == Lesson.State.PLAYBACK})
    }






}