package com.caysever.process

class GroovyProcess {

    static void main(String[] args) {
        def process = "ls -l".execute()
        println "Found text ${process.text}"

        "ls -ltr".execute().in.eachLine { line ->
            println line
        }

    }
}
