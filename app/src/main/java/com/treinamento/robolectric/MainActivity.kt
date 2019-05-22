package com.treinamento.robolectric

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login_field_username.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                login_buttom.isEnabled =
                    login_field_username.text.toString().isNotEmpty() && login_field_password.text.toString().isNotEmpty()
            }
        })

        login_field_password.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                login_buttom.isEnabled =
                    login_field_username.text.toString().isNotEmpty() && login_field_password.text.toString().isNotEmpty()
            }
        })

        login_buttom.setOnClickListener {

            if (login_field_username.text.toString() != "username") {
                Toast.makeText(this@MainActivity, "Usuario invalido", Toast.LENGTH_SHORT).show()
            } else if (login_field_password.text.toString() != "12345") {
                Toast.makeText(this@MainActivity, "A senha está errada", Toast.LENGTH_SHORT).show()
            } else {

                startActivity(Intent(this@MainActivity, MainListActivity::class.java))
            }
        }
    }
}
