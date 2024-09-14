package com.example.myheroeapp.models

class Publisher (val id: Int, val name: String, val img: String){
    companion object {
        val publishers = mutableListOf<Publisher>(
            Publisher(1, "Marvel", "https://i.pinimg.com/736x/06/59/ee/0659ee4a07929a77ea29da8b6d996754.jpg"),
            Publisher(2, "DC", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXhWui28ATrpS1FkycmbdFc__hzWtTjlRiPg&s")
        )
    }
}