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

class ReplyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reply)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left+32, systemBars.top+32, systemBars.right+32, systemBars.bottom+32)
            insets
        }

        var tvTitle2 = findViewById<TextView>(R.id.tvTitle2)
        var tvMessage = findViewById<TextView>(R.id.tvMessage)
        var etReply = findViewById<EditText>(R.id.etReply)
        var btnSend2 = findViewById<Button>(R.id.btnSend2)

        var message: String = intent.extras?.getString("extra_message").orEmpty()
        if (message.isNotEmpty()) {
            tvTitle2.text = "Message received!"
            tvMessage.text = message
        }

        btnSend2.setOnClickListener {
            var reply = etReply.text.toString()
            if (reply.isNotEmpty()) {
                var intent = Intent(this, MessageActivity::class.java)
                intent.putExtra("extra_reply",reply)
                startActivity(intent)
            }
        }
    }
}