package org.example;

import static org.example.Constants.BOTTOM_TOKEN_SHIFT;
import static org.example.Constants.MIDDLE_TOKEN_SHIFT;
import static org.example.Constants.RAW_RECORD_LENGTH;
import static org.example.Constants.SINGLE_TOKEN_SPAN;

import java.util.HashMap;
import java.util.Map;

public class RecordParser {

    private final String record;
    private int currentTokenIndex = 0;

    private final Map<String, Character> bankOfValidTokens = new HashMap<>();

    {
        bankOfValidTokens.put(" _ | ||_|", '0');
        bankOfValidTokens.put("     |  |", '1');
        bankOfValidTokens.put(" _  _||_ ", '2');
        bankOfValidTokens.put(" _  _| _|", '3');
        bankOfValidTokens.put("   |_|  |", '4');
        bankOfValidTokens.put(" _ |_  _|", '5');
        bankOfValidTokens.put(" _ |_ |_|", '6');
        bankOfValidTokens.put(" _   |  |", '7');
        bankOfValidTokens.put(" _ |_||_|", '8');
        bankOfValidTokens.put(" _ |_| _|", '9');
    }

    public RecordParser(String record) {
        this.record = record;
    }

    public boolean hasNextToken() {
        return currentTokenIndex < RAW_RECORD_LENGTH;
    }

    public char getNextToken() {
        String characters = "";

        //todo extract common logic?
        characters = characters + record.substring(currentTokenIndex, currentTokenIndex + SINGLE_TOKEN_SPAN);
        characters = characters + record.substring(currentTokenIndex + MIDDLE_TOKEN_SHIFT, currentTokenIndex + MIDDLE_TOKEN_SHIFT + SINGLE_TOKEN_SPAN);
        characters = characters + record.substring(currentTokenIndex + BOTTOM_TOKEN_SHIFT, currentTokenIndex + BOTTOM_TOKEN_SHIFT + SINGLE_TOKEN_SPAN);

//        if (bankOfValidTokens.containsKey(characters)) {
        currentTokenIndex += 3;

        return bankOfValidTokens.get(characters);
//        }
        //todo handle exception cases
        //todo increment the index in case of exception?

//        return
    }
}
