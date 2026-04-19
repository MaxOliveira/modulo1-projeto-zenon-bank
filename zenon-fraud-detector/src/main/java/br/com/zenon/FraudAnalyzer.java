package br.com.zenon;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class FraudAnalyzer {
    public List<Transaction> getTotalFrauds(List<Transaction> transactionList) {
        return transactionList.stream().filter(transaction -> transaction.isFraud() == 1).toList();
    }

    public List<Transaction> getFraudsMaiorValor(List<Transaction> transactionList) {
        return transactionList.stream().sorted(Comparator.comparing(Transaction::amount).reversed())
                .limit(3).toList();
    }

    public List<Transaction> getFraudsNameOrig(List<Transaction> transactionList) {
        return getTotalFrauds(transactionList).stream().distinct()
                .sorted(Comparator.comparing(Transaction::amount).reversed())
                .limit(5).toList();
    }

    public BigDecimal getTotalAmount(List<Transaction> transactionList){
        return getTotalFrauds(transactionList).stream()
                .map(Transaction::amount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Integer getFraudsByTypeCount(List<Transaction> transactionList, String type){
        return transactionList.stream().filter(transaction ->
                        transaction.type().equals(type) && transaction.isFraud() == 1).toList()
                .size();
    }
}
