package com.pppb.tb01.model

class Food(name: String, desc: String) {
    private var name: String = ""
    private var descriptions: String = ""
    private var tags: List<String> = ArrayList()
    private var ingredients: List<String> = ArrayList()
    private var steps: List<String> = ArrayList()
    private var restaurants: List<String> = ArrayList()

    init {
        this.name = name
        this.descriptions  = desc
    }

    fun setDescriptions(desc: String) {
        this.descriptions = desc
    }

    fun setTags(tags: List<String>) {
        this.tags = tags
    }

    fun setIngredients(ingredients: List<String>) {
        this.ingredients = ingredients
    }

    fun setSteps(steps: List<String>) {
        this.steps = steps
    }

    fun setRestaurants(restaurants: List<String>) {
        this.restaurants = restaurants
    }

    fun addTag(tag: String) {
        this.tags.plus(tag)
    }

    fun addIngredient(ingredient: String) {
        this.ingredients.plus(ingredient)
    }

    fun addStep(step: String) {
        this.steps.plus(step)
    }

    fun addRestaurant(restaurant: String) {
        this.restaurants.plus(restaurant)
    }

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