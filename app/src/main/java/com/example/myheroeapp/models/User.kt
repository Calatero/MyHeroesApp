package com.example.myheroeapp.models

data class User (val email: String, val password: String, val name: String) {
    companion object{
        val staticUser = listOf(
            User(email="diego@gmail.com", password = "12345", name="Diego"),
            User(email="eliseo@gmail.com", password = "12345", name="Eliseo"),
            User(email="juan@gmail.com", password = "12345", name="Juan"),
            User(email="samuel@gmail.com", password = "12345", name="Samuel"),
            User(email="koke@gmail.com", password = "12345", name="Koke")
        )
    }
}