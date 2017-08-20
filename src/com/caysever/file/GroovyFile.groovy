package com.caysever.file

class GroovyFile {

    static void main(String[] args) {

        def baseDir = "/tmp/"
        def fileName = 'haiku'

        File file = File.createTempFile(fileName, ".txt",new File(baseDir))


        file.withWriter('utf-8') {
            writer ->
                writer.writeLine 'Into the ancient pond'
                writer.writeLine 'A frog jumps'
                writer.writeLine 'Water’s sound!'
        }

        file << "Say hi!"

        file.eachLine { line, nb ->
            println "Line $nb: $line"
        }

        def fileContent = file as String[]
        fileContent.each {println it}

        new File(file.getParent()).eachFileMatch(~/.*.txt/){it -> println it.getAbsolutePath()}
        new File(file.getParent()).eachFileMatch(~/.*.txt/){it -> it.delete()}
    }
}
