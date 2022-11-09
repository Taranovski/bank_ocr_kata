package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class OcrReaderTest {

    private final OcrReader ocrReader = new OcrReader();

    private final String input;
    private final String output;

    public OcrReaderTest(String input, String output) {
        this.input = input;
        this.output = output;
    }

    @Parameterized.Parameters(name = "{0} -> {1}")
    public static Object[][] parameters() {
        return new Object[][]{
                {" _  _  _  _  _  _  _  _  _ \n| || || || || || || || || |\n|_||_||_||_||_||_||_||_||_|", "000000000"},
                {"                           \n  |  |  |  |  |  |  |  |  |\n  |  |  |  |  |  |  |  |  |", "111111111"},
                {" _  _  _  _  _  _  _  _  _ \n _| _| _| _| _| _| _| _| _|\n|_ |_ |_ |_ |_ |_ |_ |_ |_ ", "222222222"},
                {" _  _  _  _  _  _  _  _  _ \n _| _| _| _| _| _| _| _| _|\n _| _| _| _| _| _| _| _| _|", "333333333"},
                {"                           \n|_||_||_||_||_||_||_||_||_|\n  |  |  |  |  |  |  |  |  |", "444444444"},
                {" _  _  _  _  _  _  _  _  _ \n|_ |_ |_ |_ |_ |_ |_ |_ |_ \n _| _| _| _| _| _| _| _| _|", "555555555"},
                {" _  _  _  _  _  _  _  _  _ \n|_ |_ |_ |_ |_ |_ |_ |_ |_ \n|_||_||_||_||_||_||_||_||_|", "666666666"},
                {" _  _  _  _  _  _  _  _  _ \n  |  |  |  |  |  |  |  |  |\n  |  |  |  |  |  |  |  |  |", "777777777"},
                {" _  _  _  _  _  _  _  _  _ \n|_||_||_||_||_||_||_||_||_|\n|_||_||_||_||_||_||_||_||_|", "888888888"},
                {" _  _  _  _  _  _  _  _  _ \n|_||_||_||_||_||_||_||_||_|\n _| _| _| _| _| _| _| _| _|", "999999999"},
//                {"    _  _     _  _  _  _  _  _ \n  | _| _||_||_ |_   ||_||_|| |\n  ||_  _|  | _||_|  ||_| _||_|", "1234567890"},
//                {" _ \n| |\n|_|", "0"},
//                {"      \n  |  |\n  |  |", "11"},
        };
    }

    @Test
    public void shouldRunTheCase() {
        String account = ocrReader.readBankAccount(input);

        assertEquals(account, output);
    }
}