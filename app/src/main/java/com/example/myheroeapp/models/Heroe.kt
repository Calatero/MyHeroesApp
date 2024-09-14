package com.example.myheroeapp.models

data class Heroe(val id: Int, val name: String, val img: String, val publisherId: Int) {
    companion object{
        val heroes = mutableListOf<Heroe>(
            Heroe(1, "Spider-Man", "https://i.pinimg.com/564x/08/53/8d/08538d8025e779b89e37c39f384e10c1.jpg", 1),
            Heroe(2, "Thor", "https://i.pinimg.com/564x/51/26/a6/5126a689366a5846ede1aa20abe81955.jpg", 1),
            Heroe(3, "Iron Man",  "https://i.pinimg.com/564x/c9/a0/4b/c9a04baa9ef3be6ebca4e20b76e4e7b3.jpg", 1),
            Heroe(4, "Wolverine", "https://i.pinimg.com/736x/47/c5/16/47c516773af1db2336259e6a6741099e.jpg", 1),
            Heroe(5,"Hulk","https://i.pinimg.com/564x/d5/73/73/d573733eef63b4d8fbc44afddbd90755.jpg",1),
            Heroe(6, "Batman", "https://i.pinimg.com/564x/65/46/72/654672a5155c555f7645447341ae5af4.jpg", 2),
            Heroe(7, "Superman", "https://i.pinimg.com/564x/d3/7b/ff/d37bffd03f8ea86b9493a82eb119e4f0.jpg", 2),
            Heroe(8, "Linterna Verde", "https://i.pinimg.com/564x/6b/e8/5c/6be85c9805391f8f04da3401bba76d38.jpg", 2),
            Heroe(9, "Aquaman","https://i.pinimg.com/564x/83/c8/5a/83c85a9f512e30b769d866572b150d5b.jpg", 2),
            Heroe(10, "Flash", "https://i.pinimg.com/564x/2a/e2/70/2ae270dac409db1c5006395ff62fb0d8.jpg", 2),
            )
    }
}