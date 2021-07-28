package com.elliot.mysingletonpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


//싱글톤
//생성자 호출시 마다 객체를 생성하여 메모리 낭비를 하는것이 하니라
//객체를 하나만 생성하고 생성자 호출시에는 이미 만들어진 객체를 가져다 사용하여
//불필요하게 메모리를 사용하지 않도록 해줌.
class MainActivity : AppCompatActivity() {

    val TAG : String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity - onCreate() called")

        //주소값이 다르다. (즉, 둘이 다른 객체임) 일반 Class로 만듬
        val myNormalClass_1 = MyNormalClass()
        val myNormalClass_2 = MyNormalClass()

        Log.d(TAG, "MainActivity - myNormalClass_1 : $myNormalClass_1")
        Log.d(TAG, "MainActivity - myNormalClass_2 : $myNormalClass_2")

        //주소값이 같다. (즉, 둘이 같은 객체임) Object로 만듬. 매개변수 전달 불가
        val mySingletonClass_1 = MySingletonClass
        val mySingletonClass_2 = MySingletonClass

        Log.d(TAG, "MainActivity - mySingletonClass_1 : $mySingletonClass_1")
        Log.d(TAG, "MainActivity - mySingletonClass_2 : $mySingletonClass_2")

        //Class로 만들면서 Singleton은 어떻게??

        //주소값이 다르다. (즉, 둘이 다른 객체임) Class로 만듬.
        val mySQLOpenHelper_1 = MySQLOpenHelper(this)
        val mySQLOpenHelper_2 = MySQLOpenHelper(this)

        Log.d(TAG, "MainActivity - mySQLOpenHelper_1 : $mySQLOpenHelper_1")
        Log.d(TAG, "MainActivity - mySQLOpenHelper_2 : $mySQLOpenHelper_2")

        //주소값이 같다. (즉, 둘이 같은 객체임) Class로 만듬.
        //Class 내부에 companion object안에서 객체생성 함수를 만듬.
        val mySQLOpenHelperSingleton_1 = MySQLOpenHelperSingleton.getInstance(this)
        val mySQLOpenHelperSingleton_2 = MySQLOpenHelperSingleton.getInstance(this)

        Log.d(TAG, "MainActivity - mySQLOpenHelperSingleton_1 : $mySQLOpenHelperSingleton_1")
        Log.d(TAG, "MainActivity - mySQLOpenHelperSingleton_2 : $mySQLOpenHelperSingleton_2")


    }
}