package com.pppb.tb01.storage

import com.pppb.tb01.model.Food

object FoodListData {

    //Template
    /*
    Food(
        "\uD83C\uDF6A title",
        "desc",
        listOf<String>("tag", "tag", "tag", "tag"),
        listOf<String>(
        "ingredients",
        "ingredients",
        "ingredients",
        "ingredients"
        ),
        listOf<String>(
        "steps",
        "steps"
        ),
        listOf<String>(
        "restaurant",
        "restaurant",
        "restaurant"
        )
    ),
    */

    fun getInitialFoodList() = listOf<Food>(
        Food(
            "\uD83C\uDF5D Spaghetti alla Carbonara",
            "This dish was created in the Lazio region (the area around Rome) in the middle of the 20th century, after World War Two. We don't use cream, milk, garlic, onions or other strange ingredients; we use only guanciale, eggs, pecorino cheese, and lots of black pepper (carbonaro is the Italian for coal miner). This isn't the Italian-American version, it's the real, creamy carbonara and it comes right from Italy, where I live. Buon appetito.",
            listOf<String>("Spaghetti", "Carbonara", "Food", "Lunch", "Italian"),
            listOf<String>(
                "2 teaspoons olive oil",
                "1 pound guanciale (cured pork cheek), diced",
                "1 (16 ounce) package spaghetti",
                "3 large eggs eggs",
                "10 tablespoons grated Pecorino Romano cheese, divided",
                "salt and ground black pepper to taste"
            ),
            listOf<String>(
                "Heat olive oil in a large skillet over medium heat; add guanciale (see Cook's Note). Cook, turning occasionally, until evenly browned and crispy, 5 to 10 minutes. Remove from heat and drain on paper towels.",
                "Bring a large pot of salted water to a boil. Cook spaghetti in the boiling water, stirring occasionally until tender yet firm to the bite, about 9 minutes. Drain and return to the pot. Let cool, stirring occasionally, about 5 minutes.",
                "Whisk eggs, half of the Pecorino Romano cheese, and some black pepper in a bowl until smooth and creamy. Pour egg mixture over pasta, stirring quickly, until creamy and slightly cooled. Stir in guanciale. Top with remaining Pecorino Romano cheese and more black pepper."
            ),
            listOf<String>(
                "Jardin Resto",
                "Giggle Box",
                "ButterCup"
            )
        ),
        Food(
            "\uD83C\uDF71 Fried Rice Restaurant Style",
            "A quick fried rice like you get at your favorite Chinese restaurant. A couple of eggs, baby carrots, peas and soy sauce is all you need. ",
            listOf<String>("Fried Rice", "Food", "Lunch", "Asian"),
            listOf<String>(
                "2 cups enriched white rice",
                "4 cups water",
                "⅔ cup chopped baby carrots",
                "½ cup frozen green peas",
                "2 tablespoons vegetable oil",
                "2 large eggs eggs",
                "soy sauce to taste",
                "2 tablespoons sesame oil, to taste"
            ),
            listOf<String>(
                "In a saucepan, combine rice and water. Bring to a boil. Reduce heat, cover, and simmer for 20 minutes.",
                "In a small saucepan, boil carrots in water about 3 to 5 minutes. Drop peas into boiling water, and drain.",
                "Heat wok over high heat. Pour in oil, then stir in carrots and peas; cook about 30 seconds. Crack in eggs, stirring quickly to scramble eggs with vegetables. Stir in cooked rice. Shake in soy sauce, and toss rice to coat. Drizzle with sesame oil, and toss again."
            ),
            listOf<String>(
                "Jardin Resto",
                "Mentari Home Food and Resto",
                "Butter Cup",
            )
        ),
        Food(
            "\uD83C\uDF5B Indian Chicken Curry (Murgh Kari)",
            "This is a really good recipe for spicy Indian chicken curry. It's pretty easy to make and tastes really good!",
            listOf<String>("Asian", "Food", "Lunch", "Indian", "Curry"),
            listOf<String>(
                "2 pounds skinless, boneless chicken breast halves",
                "2 teaspoons salt",
                "½ cup cooking oil",
                "1 ½ cups chopped onion",
                "1 tablespoon minced garlic",
                "1 ½ teaspoons minced fresh ginger root",
                "1 tablespoon curry powder",
                "1 teaspoon ground cumin",
                "1 teaspoon ground turmeric",
                "1 teaspoon ground coriander",
                "1 teaspoon cayenne pepper",
                "1 tablespoon water",
                "1 (15 ounce) can crushed tomatoes",
                "1 cup plain yogurt",
                "1 tablespoon chopped fresh cilantro",
                "1 teaspoon salt",
                "½ cup water",
                "1 teaspoon garam masala",
                "1 tablespoon chopped fresh cilantro",
                "1 tablespoon fresh lemon juice"
            ),
            listOf<String>(
                "Sprinkle the chicken breasts with 2 teaspoons salt.",
                "Heat the oil in a large skillet over high heat; partially cook the chicken in the hot oil in batches until completely browned. Transfer the browned chicken breasts to a plate and set aside.",
                "Reduce the heat under the skillet to medium-high; add the onion, garlic, and ginger to the oil remaining in the skillet and cook and stir until the onion turns translucent, about 8 minutes. Stir the curry powder, cumin, turmeric, coriander, cayenne, and 1 tablespoon of water into the onion mixture; allow to heat together for about 1 minute while stirring. Mix the tomatoes, yogurt, 1 tablespoon chopped cilantro, and 1 teaspoon salt into the mixture. Return the chicken breast to the skillet along with any juices on the plate. Pour 1/2 cup water into the mixture; bring to a boil, turning the chicken to coat with the sauce. Sprinkle the garam masala and 1 tablespoon cilantro over the chicken.",
                "Cover the skillet and simmer until the chicken breasts are no longer pink in the center and the juices run clear, about 20 minutes. An instant-read thermometer inserted into the center should read at least 165 degrees F (74 degrees C). Sprinkle with lemon juice to serve."
            ),
            listOf<String>(
                "Queen's Tandoor",
                "GH International Restaurant",
                "Udupi Delicious",
            )
        ),
        Food(
            "\uD83C\uDF5A Bibimbap (Korean Rice With Mixed Vegetables)",
            "Along with kimchi, bibimbap takes its place among the favored foods in Korean cuisine. Literally meaning 'mixed rice,' it's a popular meal consisting of white rice topped with vegetables, beef, a whole egg, and gochujang (red chili pepper paste). For those who cannot handle the spiciness (like our children), you can substitute with soy sauce or Sriracha (rooster sauce) in place of it. ",
            listOf<String>("Potato", "Mashed", "Food", "Dessert"),
            listOf<String>(
                "1 English cucumber, cut into matchsticks",
                "¼ cup gochujang (Korean hot pepper paste)",
                "1 bunch fresh spinach, cut into thin strips",
                "1 tablespoon soy sauce",
                "1 teaspoon olive oil",
                "2 carrot, (7 - 1/2)s carrots, cut into matchsticks",
                "1 clove garlic, minced",
                "1 pinch red pepper flakes",
                "1 pound thinly-sliced beef top round steak",
                "1 teaspoon olive oil",
                "4 large eggs large eggs",
                "4 cups cooked white rice",
                "4 teaspoons toasted sesame oil, divided",
                "1 teaspoon sesame seeds",
                "2 teaspoons gochujang (Korean hot pepper paste), divided"
            ),
            listOf<String>(
                "Stir cucumber pieces with 1/4 cup gochujang paste in a bowl; set aside.",
                "Bring about 2 cups of water to a boil in a large nonstick skillet and stir in spinach; cook until spinach is bright green and wilted, 2 to 3 minutes. Drain spinach and squeeze out as much moisture as possible; set spinach aside in a bowl and stir soy sauce into spinach.",
                "Heat 1 teaspoon olive oil in large nonstick skillet and cook and stir carrots until softened, about 3 minutes; stir in garlic and cook just until fragrant, about 1 more minute. Stir in cucumber pieces with gochujang paste; sprinkle with red pepper flakes, and set the mixture aside in a bowl.",
                "Brown beef in a clean nonstick skillet over medium heat, about 5 minutes per side, and set aside. In a separate nonstick skillet, heat 1 more teaspoon olive oil over medium-low heat and fry the eggs just on one side until yolks are runny but whites are firm, 2 to 4 minutes each.",
                "To assemble the dish, divide cooked rice into 4 large serving bowls; top with spinach mixture, a few pieces of beef, and cucumber mixture. Place 1 egg atop each serving. Drizzle each bowl with 1 teaspoon of sesame oil, a sprinkle of sesame seeds, and a small amount of gochujang paste if desired."
            ),
            listOf<String>(
                "Mujigae",
                "HokaHoka Bento"
            )
        ),
        Food(
            "\uD83E\uDD54 Mashed Potato",
            "Mashed potato or mashed potatoes, colloquially known as mash, is a dish of mashing boiled potatoes, usually with added milk, butter, salt and pepper. It is generally served as a side dish to meat or vegetables. When the potatoes are only roughly mashed, they are sometimes called smashed potatoes.",
            listOf<String>("Potato", "Mashed", "Food", "Lunch", "Western"),
            listOf<String>(
                "2 pounds baking potatoes, peeled and quartered",
                "2 tablespoons butter",
                "1 cup milk",
                "salt and pepper to taste"
            ),
            listOf<String>(
                "Bring a pot of salted water to a boil. Add potatoes and cook until tender but still firm, about 15 minutes; drain.",
                "In a small saucepan heat butter and milk over low heat until butter is melted. Using a potato masher or electric beater, slowly blend milk mixture into potatoes until smooth and creamy. Season with salt and pepper to taste."
            ),
            listOf<String>(
                "Home",
                "Buttercup",
                "Jardin Resto"
            )
        ),
        Food(
            "\uD83C\uDF6A Peanut Butter Coconut Cookies",
            "These cookies are not chewy in the same way a traditional peanut butter cookie is chewy. The chewiness of this cookie comes from the texture of brown sugar baked into peanut butter. Because the base of this cookie is made from those two ingredients (and contains no flour), it is free of gluten and easy to make.",
            listOf<String>("Peanut", "Butter", "Cookies", "Appetizer", "Western"),
            listOf<String>(
                "1 large egg, room temperature, beaten",
                "1 cup sugar",
                "1 cup creamy peanut butter",
                "1/2 cup sweetened shredded coconut"
            ),
            listOf<String>(
                "Preheat oven to 350°. In a large bowl, mix all ingredients. Scoop level tablespoonfuls and roll into balls. Place on ungreased baking sheets and flatten with a fork.",
                "Bake until set, about 15 minutes. Remove to wire racks to cool."
            ),
            listOf<String>(
                "Amaro Cake & Pastry",
                "Kartika Sari",
                "Starbucks",
                "Bawean"
            )
        ),
        Food(
            "\uD83D\uDC14 Asian Orange Chicken",
            "A delicious citrus chicken recipe with flavors reminiscent of the orange chicken from a popular restaurant in the mall. ",
            listOf<String>("Asian", "Chicken", "Lunch"),
            listOf<String>(
                "1 ½ cups water ",
                "2 tablespoons orange juice",
                "¼ cup lemon juice",
                "⅓ cup rice vinegar",
                "2 ½ tablespoons soy sauce",
                "1 tablespoon grated orange zest",
                "1 cup packed brown sugar",
                "½ teaspoon minced fresh ginger root",
                "½ teaspoon minced garlic",
                "2 tablespoons chopped green onion",
                "¼ teaspoon red pepper flakes",
                "3 tablespoons cornstarch",
                "2 tablespoons water",
                "2 breast half, bone and skin removed (blank)s boneless, skinless chicken breasts, cut into 1/2 inch pieces",
                "1 cup all-purpose flour",
                "¼ teaspoon salt",
                "¼ teaspoon pepper",
                "3 tablespoons olive oil"
            ),
            listOf<String>(
                "Pour 1 1/2 cups water, orange juice, lemon juice, rice vinegar, and soy sauce into a saucepan and set over medium-high heat. Stir in the orange zest, brown sugar, ginger, garlic, chopped onion, and red pepper flakes. Bring to a boil. Remove from heat, and cool 10 to 15 minutes.",
                "Place the chicken pieces into a resealable plastic bag. When contents of saucepan have cooled, pour 1 cup of sauce into bag. Reserve the remaining sauce. Seal the bag, and refrigerate at least 2 hours.",
                "In another resealable plastic bag, mix the flour, salt, and pepper. Add the marinated chicken pieces, seal the bag, and shake to coat.",
                "Heat the olive oil in a large skillet over medium heat. Place chicken into the skillet, and brown on both sides. Drain on a plate lined with paper towels, and cover with aluminum foil.",
                "Wipe out the skillet, and add the sauce. Bring to a boil over medium-high heat. Mix together the cornstarch and 2 tablespoons water; stir into the sauce. Reduce heat to medium low, add the chicken pieces, and simmer, about 5 minutes, stirring occasionally."
            ),
            listOf<String>(
                "Panda Express",
                "Atmosphere Resrt Cafe",
                "The Stone Cafe",
                "Hotel Padma Bandung"
            )
        ),
        Food(
            "\uD83E\uDD5A Egg Rolls",
            "These are fabulous as a side dish with stir-fry dishes. Serve warm with egg roll sauce or soy sauce if desired. ",
            listOf<String>("Asian", "Egg", "Dessert", "Appetizer"),
            listOf<String>(
                "1 pound ground pork",
                "1 teaspoon ground ginger",
                "1 teaspoon garlic powder",
                "1 quart peanut oil for frying",
                "2 tablespoons all-purpose flour",
                "2 tablespoons water",
                "2 cups shredded cabbage",
                "2 ounces shredded carrots",
                "8 (7 inch square) egg roll wrappers",
                "2 tablespoons sesame seeds"
            ),
            listOf<String>(
                "Season pork with ginger and garlic powder and mix thoroughly. Heat mixture in a medium skillet, stirring, until pork is cooked through and no longer pink. Set aside.",
                "In another large skillet heat oil to about 375 degrees F (190 degrees C) or medium high heat. While oil is heating, combine flour and water in a bowl until they form a paste. In a separate bowl combine the cabbage, carrots and reserved pork mixture. Mix all together.",
                "Lay out one egg roll skin with a corner pointed toward you. Place about a 1/4 to 1/3 cup of the cabbage, carrot and pork mixture on egg roll paper and fold corner up over the mixture. Fold left and right corners toward the center and continue to roll. Brush a bit of the flour paste on the final corner to help seal the egg roll.",
                "Place egg rolls into heated oil and fry, turning occasionally, until golden brown. Remove from oil and drain on paper towels or rack. Put on serving plate and top with sesame seeds if desired."
            ),
            listOf<String>(
                "The Stone Cafe",
                "ButterCup",
                "jardin Cafe"
            )
        ),
        Food(
            "\uD83E\uDD69 Beef Bulgogi",
            "Just like my Korean mom makes it! It's delicious! Even better if rolled up in red leaf lettuce with rice and hot pepper paste. If you want to spice it up just add red pepper powder to your marinade. ",
            listOf<String>("Asian", "Korean", "Beef", "Lunch"),
            listOf<String>(
                "1 pound flank steak, thinly sliced",
                "5 tablespoons soy sauce",
                "2 ½ tablespoons white sugar",
                "¼ cup chopped green onion",
                "2 tablespoons minced garlic",
                "2 tablespoons sesame seeds",
                "2 tablespoons sesame oil",
                "½ teaspoon ground black pepper"
            ),
            listOf<String>(
                "Place the beef in a shallow dish. Combine soy sauce, sugar, green onion, garlic, sesame seeds, sesame oil, and ground black pepper in a small bowl. Pour over beef. Cover and refrigerate for at least 1 hour or overnight.",
                "Preheat an outdoor grill for high heat, and lightly oil the grate.",
                "Quickly grill beef on hot grill until slightly charred and cooked through, 1 to 2 minutes per side."
            ),
            listOf<String>(
                "Braga Permai",
                "Mujigae"
            )
        ),
        Food(
            "\uD83D\uDC16 Char Siu (Chinese BBQ Pork)",
            "\"Char siu\" literally means \"fork roast\" - \"char\" being \"fork\" (both noun and verb) and \"siu\" being \"roast\" - after the traditional cooking method for the dish: long strips of seasoned boneless pork are skewered with long forks and placed in a covered oven or over a fire. This is best cooked over charcoal, but it's important to cook with indirect heat. ",
            listOf<String>("tag", "tag", "tag", "tag"),
            listOf<String>(
                "2 eaches pork tenderloins",
                "½ cup soy sauce",
                "⅓ cup honey",
                "⅓ cup ketchup",
                "⅓ cup brown sugar",
                "¼ cup Chinese rice wine",
                "2 tablespoons hoisin sauce",
                "½ teaspoon red food coloring",
                "1 teaspoon Chinese five-spice powder "
            ),
            listOf<String>(
                "Cut pork with the grain into strips 1 1/2- to 2-inches long; put into a large resealable plastic bag.",
                "Stir soy sauce, honey, ketchup, brown sugar, rice wine, hoisin sauce, red food coloring or red bean curd (see Cook's Note), and Chinese five-spice powder together in a saucepan over medium-low heat. Cook and stir until just combined and slightly warm, 2 to 3 minutes. Pour the marinade into the bag with the pork, squeeze air from the bag, and seal. Turn bag a few times to coat all pork pieces in marinade.",
                "Marinate pork in refrigerator, 2 hours to overnight.",
                "Preheat an outdoor grill for medium-high heat and lightly oil the grate.",
                "Remove pork from marinade and shake to remove excess liquid. Discard remaining marinade.",
                "Cook pork on preheated grill for 20 minutes. Put a small container of water onto the grill and continue cooking, turning the pork regularly, until cooked through, about 1 hour. An instant-read thermometer inserted into the center should read at least 145 degrees F (63 degrees C)."
            ),
            listOf<String>(
                "Kantin Qiu",
                "Nasi Campur 88",
                "Se'i Babi Lelebo"
            )
        )
    )
}