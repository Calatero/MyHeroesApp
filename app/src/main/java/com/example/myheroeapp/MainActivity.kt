package com.example.myheroeapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myheroeapp.models.User
import com.example.myheroeapp.ui.PublisherActivity

class MainActivity : AppCompatActivity() {
    lateinit var loginBtn : Button
    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val sharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE)
        val isLogged = sharedPreferences.getBoolean("isLogged", false)
        val intent = Intent(this@MainActivity, PublisherActivity::class.java)
        if(isLogged){
            startActivity(intent)
            finish()
        }
        loginBtn = findViewById(R.id.loginBtn)
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginBtn.setOnClickListener{
            Log.i("LOGAPP", "Iniciar sesión")
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            Log.i("EMAIL",email)
            Log.i("PASSWORD",password)
            if(email.isEmpty() || password.isEmpty()){
                Log.i("ERROR","El correo electrónico o contraseña esta vacio.")
                return@setOnClickListener
            }
            val isValidUser = User.staticUser.any{
                    user -> user.email == email && user.password == password
            }
            if(!isValidUser){
                Log.i("ERROR", "El correo o la contraseña no es valida.")
                return@setOnClickListener
            }
            val user = User.staticUser.firstOrNull{
                it.email == email && it.password == password
            }
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLogged",true)
            editor.putString("userEmail",user?.email)
            editor.apply()

            startActivity(intent)
            finish()
        }
    }
}