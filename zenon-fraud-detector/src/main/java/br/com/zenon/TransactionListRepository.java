package br.com.zenon;

import java.util.List;
import java.util.Optional;

public class TransactionListRepository implements TransactionRepository {
    public Optional<Transaction> getTransactionByClientName(String clientName) throws Exception {
        TransactionIngestor transactionIngestor = new TransactionIngestor();
        List<Transaction> transactionList = transactionIngestor.getTransactionList("PS_20174392719_1491204439457_log.csv");
        return transactionList.stream().filter(transaction -> transaction.nameOrig().equalsIgnoreCase(clientName)).findFirst();
    }
}
