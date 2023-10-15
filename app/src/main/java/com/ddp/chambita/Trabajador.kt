package com.ddp.chambita

class Trabajador(
    var username: String,
    var name: String,
    var email: String,
    var password: String,
    var stars: Double,
    var category: String,
    var job: String,
    var experienceYears: Int,
    var description: String,
    var insignias: List<String> = listOf(),
    var favorito: Char = 'n',
    var telefono: String
) {

}