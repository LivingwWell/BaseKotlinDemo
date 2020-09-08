package com.example.app.entity

/**
 *
 * @Description:     java类作用描述
 * @Author:          lee
 * @CreateDate:     2020/9/7 3:21 PM
 */
class User {
     var username: String?=null
     var password: String?=null
     var code: String?=null

    constructor()

    constructor(username: String, password: String, code: String) {
        this.username = username;
        this.password = password;
        this.code = code;
    }
}