package com.pppb.tb01.model

class Menu(name: String, id: Int) {
    private val name: String = name
    private val id: Int = id

    fun getName(): String {
        return this.name
    }

    fun getId(): Int {
        return this.id
    }
}