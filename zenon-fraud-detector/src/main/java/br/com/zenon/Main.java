package br.com.zenon;

import java.math.BigDecimal;

public class Main {
    static void main() {
        Transaction transaction1 = new Transaction(1, TransactionType.PAYMENT.name(),  new BigDecimal("9839.64"), "C1231006815",
                new BigDecimal("170136.0"),  new BigDecimal("160296.36"), "M1979787155",
                new BigDecimal("0.0"), new BigDecimal("0.0"), 0, 0);

        Transaction transaction2 = new Transaction(743, TransactionType.CASH_OUT.name(),  new BigDecimal("850002.52"), "C1280323807",
                new BigDecimal("850002.52"),  new BigDecimal("0.0"), "C873221189",
                new BigDecimal("6510099.11"), new BigDecimal("7360101.63"), 1, 0);

        System.out.println("Transação 1: " + transaction1);
        System.out.println("Transação 2: " + transaction2);
    }
}
