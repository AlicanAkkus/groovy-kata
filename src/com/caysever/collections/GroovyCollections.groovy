package com.caysever.list

class GroovyCollections {

    static void main(String[] args) {

        def numbers = [1, 5, 10, 50, 100, 500, 100]

        assert numbers instanceof List
        assert numbers.size() == 7

        def heterogeneous = [1, "a", true]
        assert heterogeneous instanceof List
        assert heterogeneous.size() == 3

        numbers = [2, 4, 1, 5, 3] as LinkedList
        assert numbers instanceof LinkedList
        assert numbers.size() == 5
        numbers.each { print it + " " }
        println ""

        //find first element
        numbers.find {it -> it >= 2}.each {it -> print it + " "}
        println ""
        //find all element
        numbers.findAll() {it -> it >= 2}.each {it -> print it + " "}

        assert numbers.every { it < 6 }
        assert numbers.any { it > 2 }

        numbers -=5
        numbers.each { print it + " " }
        println ""

        println ""
        // a, b, c
        ('a'..'c').each { print it + " " }

        println ""
        ['Cat', 'Dog', 'Elephant'].each {
            println "Animal ${it}"
        }

        println ""
        (['Cat', 'Dog', 'Elephant', 'Cat'] as Set).each {
            println "Animal ${it}"
        }

        println ""
        def animals = ['Cat', 'Dog', 'Elephant'] as Set
        animals << "Cat"
        animals << 'Dog'
        animals.each { print it + " " }

        println ""
        def person = ['name': 'Alican', 'surname': 'Akkus', 'age': 23]
        assert person instanceof Map
        assert person.size() == 3
        person.each { key, value -> println "$key : $value" }
        println "Name : ${person.name}"
        println "Surname : ${person.surname}"
        println "Age : ${person.age}"

        person << ['gender' : 'male']
        println "Gender : ${person.gender}"

        println ""
        person.age = 24
        println "New age : ${person.age}"

        println ""
        def collectAnimals = animals.collectEntries { [(it) : it.length()] }
        collectAnimals.each {animal, length -> println "Animal $animal has $length char."}

        println "Max char in animals is ${collectAnimals.max {it.value}}"
    }
}
