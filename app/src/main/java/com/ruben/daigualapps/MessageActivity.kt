package com.ruben.daigualapps

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_message)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left+32, systemBars.top+32, systemBars.right+32, systemBars.bottom+32)
            insets
        }

        var tvTitle = findViewById<TextView>(R.id.tvTitle)
        var tvReply = findViewById<TextView>(R.id.tvReply)
        var etMessage = findViewById<EditText>(R.id.etMessage)
        var btnSend = findViewById<Button>(R.id.btnSend)

        var reply = intent.extras?.getString("extra_reply").orEmpty()
        if (reply.isNotEmpty()) {
            tvTitle.text = "Reply received!"
            tvReply.text = reply
        }

        btnSend.setOnClickListener {
            var message = etMessage.text.toString()
            if (message.isNotEmpty()) {
                var intent = Intent(this, ReplyActivity::class.java)
                intent.putExtra("extra_message",message)
                startActivity(intent)
            }
        }
    }
}