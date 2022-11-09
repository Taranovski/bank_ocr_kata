package org.example

import spock.lang.Specification
import spock.lang.Unroll

class OcrReaderTest1 extends Specification {

    private static final OcrReader reader = new OcrReader();

    @Unroll("Reading #expected")
    def "Basic reader cases"() {
        expect:
        reader.read(input) == expected

        where:

        input                                                                                            || expected
        " _  _  _  _  _  _  _  _  _ \n| || || || || || || || || |\n|_||_||_||_||_||_||_||_||_|"          || "000000000"
        "                           \n  |  |  |  |  |  |  |  |  |\n  |  |  |  |  |  |  |  |  |"          || "111111111"
        " _  _  _  _  _  _  _  _  _ \n _| _| _| _| _| _| _| _| _|\n|_ |_ |_ |_ |_ |_ |_ |_ |_ "          || "222222222"
        " _  _  _  _  _  _  _  _  _ \n _| _| _| _| _| _| _| _| _|\n _| _| _| _| _| _| _| _| _|"          || "333333333"
        "                           \n|_||_||_||_||_||_||_||_||_|\n  |  |  |  |  |  |  |  |  |"          || "444444444"
        " _  _  _  _  _  _  _  _  _ \n|_ |_ |_ |_ |_ |_ |_ |_ |_ \n _| _| _| _| _| _| _| _| _|"          || "555555555"
        " _  _  _  _  _  _  _  _  _ \n|_ |_ |_ |_ |_ |_ |_ |_ |_ \n|_||_||_||_||_||_||_||_||_|"          || "666666666"
        " _  _  _  _  _  _  _  _  _ \n  |  |  |  |  |  |  |  |  |\n  |  |  |  |  |  |  |  |  |"          || "777777777"
        " _  _  _  _  _  _  _  _  _ \n|_||_||_||_||_||_||_||_||_|\n|_||_||_||_||_||_||_||_||_|"          || "888888888"
        " _  _  _  _  _  _  _  _  _ \n|_||_||_||_||_||_||_||_||_|\n _| _| _| _| _| _| _| _| _|"          || "999999999"
        "    _  _     _  _  _  _  _  _ \n  | _| _||_||_ |_   ||_||_|| |\n  ||_  _|  | _||_|  ||_| _||_|" || "1234567890"
        " _ \n| |\n|_|"                                                                                  || "0"
        "      \n  |  |\n  |  |"                                                                         || "11"
    }


    def "Unknown is read as ?"() {
        given:
        def unknown = "___\n___\n___"

        when:
        def read = reader.read(unknown)

        then:
        read == "?"
    }
}
