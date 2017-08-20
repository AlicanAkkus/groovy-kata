package com.caysever.xml

import com.caysever.builder.RecordsUtil
import groovy.xml.DOMBuilder
import groovy.xml.MarkupBuilder
import groovy.xml.dom.DOMCategory

class GroovyXmlBuilder {

    static void main(String[] args) {

        def cars = RecordsUtil.records()
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
}
