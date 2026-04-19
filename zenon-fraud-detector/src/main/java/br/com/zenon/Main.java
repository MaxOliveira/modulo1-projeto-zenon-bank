package br.com.zenon;


import java.util.List;

public class Main {
    static void main() throws Exception{
        TransactionIngestor transactionIngestor = new TransactionIngestor();
        List<Transaction> transactionList = transactionIngestor.getTransactionList("PS_20174392719_1491204439457_log.csv");
        transactionList.forEach(System.out::println);
    }
}
