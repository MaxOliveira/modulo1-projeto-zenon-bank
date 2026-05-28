package br.com.zenon;

import java.util.Optional;

public class Main {
    static void main() throws Exception{
        TransactionListRepository transactionListRepository = new TransactionListRepository();
        Optional<Transaction> transactionNotFound = transactionListRepository.getTransactionByClientName("C12345");

        if (transactionNotFound.isPresent()) {
            System.out.println(transactionNotFound);
        } else {
            System.out.println("Transação não encontrada para o cliente C12345");
        }

        Optional<Transaction> transactionFound = transactionListRepository.getTransactionByClientName("C1231006815");

        if (transactionFound.isPresent()) {
            System.out.println(transactionFound.get());
        } else {
            System.out.println("Transação não encontrada para o cliente C1231006815");
        }

        Long startTime = System.nanoTime();
        transactionListRepository.getTransactionByClientName("C1868032458");
        Long endTime = System.nanoTime();
        System.out.println("Tempo de busca usando List e Stream: " + (endTime - startTime) / 1_000_000_000.0 + " segundos");

        TransactionListMapRepository transactionListMapRepository = new TransactionListMapRepository();
        Long startTime1 = System.nanoTime();
        transactionListMapRepository.getTransactionByClientName("C1868032458");
        Long endTime1 = System.nanoTime();
        System.out.println("Tempo de busca usando Map: " + (endTime1 - startTime1) / 1_000_000_000.0 + " segundos");
    }
}
