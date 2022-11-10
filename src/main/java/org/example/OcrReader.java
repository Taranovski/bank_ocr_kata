package org.example;

public class OcrReader {


    public String readBankAccount(String oneAccountRecord) {

        RecordParser recordParser = new RecordParser(oneAccountRecord);

        StringBuilder stringBuilder = new StringBuilder();

        while (recordParser.hasNextToken()) {
            stringBuilder.append(recordParser.getNextToken());

        }

        return stringBuilder.toString();
    }

}
