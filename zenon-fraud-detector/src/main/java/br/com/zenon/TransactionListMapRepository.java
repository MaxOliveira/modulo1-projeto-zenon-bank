package br.com.zenon;

import java.util.Map;
import java.util.Optional;

public class TransactionListMapRepository implements TransactionRepository{
    public Optional<Transaction> getTransactionByClientName(String clientName) throws Exception {
        TransactionIngestor transactionIngestor = new TransactionIngestor();
        Map<String, Transaction> transactionMap = transactionIngestor.getTransactionMap("PS_20174392719_1491204439457_log.csv");
        return Optional.ofNullable(transactionMap.get(clientName));
    }
}
