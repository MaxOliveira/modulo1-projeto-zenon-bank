package br.com.zenon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() throws Exception{
       List<Transaction> transactions = new ArrayList<>();
       try (BufferedReader br = new BufferedReader(new FileReader("../zenon-fraud-detector/data/PS_20174392719_1491204439457_log.csv"))) {
           br.readLine();
           int linesCount = 0;
           String line;
            while ((line = br.readLine()) != null && linesCount < 10) {
                String[] fields = line.split(",");

                Transaction transaction = new Transaction(
                        Integer.parseInt(fields[0]),        // step
                        fields[1],                          // type
                        new BigDecimal(fields[2]),          // amount
                        fields[3],                          // nameOrig
                        new BigDecimal(fields[4]),          // oldbalanceOrg
                        new BigDecimal(fields[5]),          // newbalanceOrig
                        fields[6],                          // nameDest
                        new BigDecimal(fields[7]),          // oldbalanceDest
                        new BigDecimal(fields[8]),          // newbalanceDest
                        Integer.parseInt(fields[9]),        // isFraud
                        Integer.parseInt(fields[10])        // isFlaggedFraud
                );
                transactions.add(transaction);
                linesCount++;
            }
            transactions.forEach(System.out::println);
        }
    }
}
