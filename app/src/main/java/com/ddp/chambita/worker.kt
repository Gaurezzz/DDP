package com.ddp.chambita

class worker(
    var username: String,
    var name: String,
    var email: String,
    var password: String,
    var category: String,
    var job: String,
    var experienceYears: Int,
    var description: String,
    var insignias: List<String> = listOf()
) {

}