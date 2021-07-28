package com.elliot.mysingletonpractice

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MySQLOpenHelperSingleton private constructor(context : Context) : SQLiteOpenHelper(context, "MyDB", null, 1) {

    val TAG : String = "로그"

    companion object {

        //자기 자신 변수 선언
        @Volatile private var instance : MySQLOpenHelperSingleton? = null

        //자기 자신 가져오기
        fun getInstance(context: Context) : MySQLOpenHelperSingleton =
            instance ?: synchronized(this) {
                instance ?: MySQLOpenHelperSingleton(context).also {
                    instance = it
                }
            }

    }

    override fun onCreate(db: SQLiteDatabase?) {

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

}