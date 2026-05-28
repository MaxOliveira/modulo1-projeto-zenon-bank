package br.com.zenon;

import java.util.Optional;

public interface TransactionRepository {
    Optional<Transaction> getTransactionByClientName(String clientName) throws Exception;
}
