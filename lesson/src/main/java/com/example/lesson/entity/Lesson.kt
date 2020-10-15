package com.example.lesson.entity

/**
 *
 * @Description:     java类作用描述
 * @Author:          lee
 * @CreateDate:     2020/9/7 4:53 PM
 */
class Lesson constructor(var date: String,var content: String,var state: State) {

    enum class State {
        PLAYBACK {
            override fun stateName(): String {
                return "有回放"
            }
        },
        LIVE {
            override fun stateName(): String {
                return "正在直播"
            }
        },
        WAIT {
            override fun stateName(): String {
                return "等待中"
            }
        };

        abstract fun stateName(): String?
    }

}