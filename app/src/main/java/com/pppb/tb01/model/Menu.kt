package com.pppb.tb01.model

class Menu(private val name: String, private val id: Int) {
    fun getName(): String = this.name
    fun getId(): Int = this.id
}