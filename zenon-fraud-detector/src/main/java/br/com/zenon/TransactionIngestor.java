package br.com.zenon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TransactionIngestor {

    public List<Transaction> getTransactionList(String nomeArquivo) throws Exception {
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("../zenon-fraud-detector/data/" + nomeArquivo))) {
            br.readLine();
            int linesCount = 0;
            String line;
            while ((line = br.readLine()) != null && linesCount < 50000) {
                String[] fields = line.split(",");

                try {
                    Transaction transaction = new Transaction(
                            Integer.parseInt(fields[0]),        // step
                            fields[1],                          // type
                            fields[2].trim().isEmpty() ? null : new BigDecimal(fields[2]),  // amount
                            fields[3],                          // nameOrig
                            fields[4].trim().isEmpty() ? null : new BigDecimal(fields[4]),  // oldbalanceOrg
                            fields[5].trim().isEmpty() ? null : new BigDecimal(fields[5]),  // newbalanceOrig
                            fields[6],                          // nameDest
                            fields[7].trim().isEmpty() ? null : new BigDecimal(fields[7]),  // oldbalanceDest
                            fields[8].trim().isEmpty() ? null : new BigDecimal(fields[8]),  // newbalanceDest
                            Integer.parseInt(fields[9]),        // isFraud
                            Integer.parseInt(fields[10])        // isFlaggedFraud
                    );
                    transactions.add(transaction);
                }catch (Exception e) {
                    System.err.println("Erro: " + line + " | " + e);
                }
                linesCount++;
            }
        }
        return transactions;
    }
}
