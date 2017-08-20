package com.caysever.times

class GroovyTimes {

    static void main(String[] args) {
        3.times {
            println "hi"
        }

        println ""


        3.times {
            ix ->
                2.times {
                    iy ->  println "X : $ix Y : $iy"
                }
        }

    }
}
