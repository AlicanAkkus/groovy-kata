package com.caysever.builder

class RecordsUtil {

    static LinkedList records() {
        [new Car('Hyunadi', 'i30', 2011, 130_000L, 180),
         new Car('Volvo', 'S60', 2014, 180_000L, 240)] as LinkedList
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
