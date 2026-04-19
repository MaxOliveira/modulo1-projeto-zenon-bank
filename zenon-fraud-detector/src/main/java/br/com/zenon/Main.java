package br.com.zenon;


import java.util.List;

public class Main {
    static void main() throws Exception{
        TransactionIngestor transactionIngestor = new TransactionIngestor();
        List<Transaction> transactionList1 = transactionIngestor.getTransactionList("paysim_with_bad_data.csv");
        List<Transaction> transactionList2 = transactionIngestor.getTransactionList("PS_20174392719_1491204439457_log.csv");
        transactionList1.forEach(System.out::println);
        transactionList2.forEach(System.out::println);
    }
}
