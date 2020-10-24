package com.pppb.tb01.model

class Food {
    private var id: Int = 0
    private var name: String
    private var descriptions: String
    private var tags: List<String>
    private var ingredients: List<String>
    private var steps: List<String>
    private var restaurants: List<String>

    constructor(
        id: Int,
        name: String,
        descriptions: String,
        tags: List<String>,
        ingredients: List<String>,
        steps: List<String>,
        restaurants: List<String>
    ) {
        this.id = id
        this.name = name
        this.descriptions = descriptions
        this.tags = tags
        this.ingredients = ingredients
        this.steps = steps
        this.restaurants = restaurants
    }

    constructor(
        name: String,
        descriptions: String,
        tags: List<String>,
        ingredients: List<String>,
        steps: List<String>,
        restaurants: List<String>
    ) {
        this.name = name
        this.descriptions = descriptions
        this.tags = tags
        this.ingredients = ingredients
        this.steps = steps
        this.restaurants = restaurants
    }

    fun getId(): Int = this.id
    fun getName(): String = this.name
    fun getDescriptions(): String = this.descriptions
    fun getTags(): List<String> = this.tags
    fun getIngredients(): List<String> = this.ingredients
    fun getSteps(): List<String> = this.steps
    fun getRestaurants(): List<String> = this.restaurants
    fun setId(id: Int) {
        this.id = id
    }
}