package com.caysever.string

class GroovyString {


    static void main(String[] args) {

        def firstname = "Alican"
        String lastname = "Akkus"

        println "Dear ${firstname[0]}. $lastname"

        println(firstname.getClass().getName() + " - " + lastname.getClass().getName())
        assert firstname.getClass() == lastname.getClass()

        if (firstname)
            if (lastname)
                println "Dear ${firstname[0]}. $lastname"

        def age = 24
        if (age)
            println age as String

        def fullname = firstname + " " + lastname
        assert fullname == "$firstname $lastname"
        println fullname

        def sum = "The sum of 2 and 3 equals ${2 + 3}"
        assert sum.toString() == 'The sum of 2 and 3 equals 5'

        sum = "The sum of 2 and 3 equals ${def a = 2; def b = 3; a + b}"
        assert sum.toString() == 'The sum of 2 and 3 equals 5'
        println sum
    }
}
