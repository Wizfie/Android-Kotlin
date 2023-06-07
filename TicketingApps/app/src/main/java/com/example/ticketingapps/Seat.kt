package com.example.ticketingapps

data class Seat(
    val id: Int,
    var x: Float? = 0F,
    var y: Float? = 0F,
    var name: String,
    var isBooked: Boolean,



    )


val seats : ArrayList<Seat> = arrayListOf(

    Seat(id = 1, name = "A1", isBooked = false),
    Seat(id = 2, name = "A2", isBooked = false),
    Seat(id = 3, name = "A3", isBooked = false),
    Seat(id = 4, name = "A4", isBooked = false),
    Seat(id = 5, name = "A5", isBooked = false),
    Seat(id = 6, name = "A6", isBooked = false),
    Seat(id = 7, name = "A7", isBooked = false),
    Seat(id = 8, name = "A8", isBooked = false),


)



