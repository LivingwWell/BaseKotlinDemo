package com.example.lesson

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.BaseViewHolder
import com.example.lesson.entity.Lesson

/**
 *
 * @Description:     java类作用描述
 * @Author:          lee
 * @CreateDate:     2020/9/7 4:28 PM
 */
class LessonAdapter: RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {

    private var list:List<Lesson> = ArrayList()

    fun updateAndNotify(list:List<Lesson>){
        this.list=list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        return LessonViewHolder.onCreate(parent)
    }

    override fun getItemCount(): Int {
      return list.size
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
          holder.onBind(list.get(position))
    }


    /**
     * 静态内部类
     */
    class LessonViewHolder internal constructor(itemView: View) : BaseViewHolder(itemView) {
        fun onBind(lesson: Lesson) {
            var date = lesson.date
            if (date == null) {
                date = "日期待定"
            }
            setText(R.id.tv_date, date)
            setText(R.id.tv_content, lesson.content)

            lesson.state?.let {
                setText(R.id.tv_state, it.stateName())
                var colorRes = R.color.playback
                colorRes = when (it) {
                    Lesson.State.PLAYBACK -> { // 即使在 {} 中也是需要 break 的。
                         R.color.playback }
                    Lesson.State.LIVE -> R.color.live
                    Lesson.State.WAIT -> R.color.wait
                }
                val backgroundColor = itemView.context.getColor(colorRes)
                getView<View>(R.id.tv_state)?.setBackgroundColor(backgroundColor)
            }

        }

        companion object {
            internal fun onCreate(parent: ViewGroup): LessonViewHolder {
                return LessonViewHolder(LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.item_lesson, parent, false))
            }
        }
    }


}

