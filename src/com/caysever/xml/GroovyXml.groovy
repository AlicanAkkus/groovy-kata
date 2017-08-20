package com.caysever.xml

import groovy.xml.DOMBuilder
import groovy.xml.MarkupBuilder
import groovy.xml.dom.DOMCategory

class GroovyXml {

    static void main(String[] args) {

        def cars = [new Car('Hyunadi', 'i30', 2011, 130_000L, 180),
                    new Car('Volvo', 'S60', 2014, 180_000L, 240)] as LinkedList
        def writer = new StringWriter()
        def xml = new MarkupBuilder(writer)

        xml.records() {
            cars.each {
                car(name: it.name, model: it.model, year: it.year) { ->
                    country('Turkey')
                    km(it.km)
                    maxSpeed(it.maxSpeed)
                }

            }
        }

        println writer.toString()

        def records = new XmlSlurper().parseText(writer.toString())

        assert records.car.first().@name.text() == cars[0].name
        assert records.car.last().@name.text() == cars[1].name

        records.car.each{it -> println it.@name}

        def recordsAsString = writer.toString()
        def reader = new StringReader(recordsAsString)
        def doc = DOMBuilder.parse(reader)
        def newRecords = doc.documentElement

        use(DOMCategory) {
            assert newRecords.car.size() == 2
        }

    }

    static class Car {
        def name
        def model
        def year
        def km
        def maxSpeed

        Car(name, model, year, km, maxSpeed) {
            this.name = name
            this.model = model
            this.year = year
            this.km = km
            this.maxSpeed = maxSpeed
        }


        @Override
        public String toString() {
            return "Car{" +
                    "name=" + name +
                    ", model=" + model +
                    ", year=" + year +
                    ", km=" + km +
                    ", maxSpeed=" + maxSpeed +
                    '}';
        }
    }
}
