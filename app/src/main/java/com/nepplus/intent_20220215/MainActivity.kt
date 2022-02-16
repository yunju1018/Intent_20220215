package com.nepplus.intent_20220215

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    모든 함수에서 공유할 수 있는 변수. (멤버변수/전역변수)
    val REQ_CODE_NICKNAME = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveToOtherActivity.setOnClickListener {

//            OtherActivity로 이동
            val myIntent = Intent( this, OtherActivity::class.java )
            startActivity(myIntent)

        }

        btnSendMessage.setOnClickListener {

//            1. 뭐라고 입력했는지 추출
            val inputMessage = edtMessage.text.toString()

//            2. 추출한 내용을 다른 화면에 전달하기 (화면으로 이동)
            val myIntent = Intent(this, ViewMessageActivity::class.java)

            myIntent.putExtra("message", inputMessage)

            startActivity(myIntent)

        }

        btnEditNickname.setOnClickListener {

            val myIntent = Intent(this, EditNicknameActivity::class.java)

//            새로운 닉네임을 받으러 (결과를 얻으러) 가는 동작.
            startActivityForResult(myIntent, REQ_CODE_NICKNAME)   // code 숫자값으로 용도 (닉네임 받으러감) 구별하는데 사용.

        }

    }


}