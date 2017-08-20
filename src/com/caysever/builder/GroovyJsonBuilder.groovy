package com.caysever.builder

import groovy.json.JsonBuilder
import groovy.json.JsonOutput

class GroovyJsonBuilder {

    static void main(String[] args) {

        def records = RecordsUtil.records()
        def json = new JsonBuilder()

        json.records{
            records.each {
                car{ ->
                    name it.name
                    model it.model
                    year it.year
                    km it.km
                    maxSpeed it.maxSpeed
                }
            }
        }

        println JsonOutput.prettyPrint(json.toString())
    }
}
