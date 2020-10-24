package com.pppb.tb01.model

class Food(
    private var name: String,
    private var descriptions: String,
    private var tags: List<String>,
    private var ingredients: List<String>,
    private var steps: List<String>,
    private var restaurants: List<String>
) {
    fun getName(): String {
        return this.name
    }

    fun getDescriptions(): String {
        return this.descriptions
    }

    fun getTags(): List<String> {
        return this.tags
    }

    fun getIngredients(): List<String> {
        return this.ingredients
    }

    fun getSteps(): List<String> {
        return this.steps
    }

    fun getRestaurants(): List<String> {
        return this.restaurants
    }
}