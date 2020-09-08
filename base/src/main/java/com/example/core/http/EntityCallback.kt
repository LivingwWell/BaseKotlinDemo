package com.example.core.http

/**
 *
 * @Description:     java类作用描述
 * @Author:          lee
 * @CreateDate:     2020/9/7 6:49 PM
 */
interface EntityCallback<T> {
    fun onSuccess(entity: T)

    fun onFailure(message: String?)
}