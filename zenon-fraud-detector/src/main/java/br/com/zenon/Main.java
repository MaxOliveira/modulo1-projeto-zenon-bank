package br.com.zenon;


import java.math.BigDecimal;
import java.util.List;

public class Main {
    static void main() throws Exception{
        TransactionIngestor transactionIngestor = new TransactionIngestor();
        List<Transaction> transactionList = transactionIngestor.getTransactionList("PS_20174392719_1491204439457_log.csv");

        FraudAnalyzer fraudAnalyzer = new FraudAnalyzer();
        List<Transaction> totalFraudes = fraudAnalyzer.getTotalFrauds(transactionList);
        System.out.println("1. Total de Fraudes: " + totalFraudes.size());

        List<Transaction> fraudesMaiorValor = fraudAnalyzer.getFraudsMaiorValor(transactionList);
        System.out.println("2. Top 3 Fraudes de Maior valor:");
        fraudesMaiorValor.forEach(fraude -> System.out.println(fraude.amount()));

        List<Transaction> fraudesNameOrig = fraudAnalyzer.getFraudsNameOrig(transactionList);
        System.out.println("3. Clientes Suspeitos:");
        fraudesNameOrig.forEach(fraude -> System.out.println(fraude.nameOrig()));

        BigDecimal totalAmount = fraudAnalyzer.getTotalAmount(transactionList);
        System.out.println("4. Prejuizo Total: " + totalAmount);
        fraudesNameOrig.forEach(fraude -> System.out.println(fraude.nameOrig()));

        System.out.println("5. Fraudes por Tipo: ");
        System.out.println("- CASH_IN: " + fraudAnalyzer.getFraudsByTypeCount(transactionList, TransactionType.CASH_IN.name()));
        System.out.println("- CASH_OUT: " + fraudAnalyzer.getFraudsByTypeCount(transactionList, TransactionType.CASH_OUT.name()));
        System.out.println("- TRANSFER: " + fraudAnalyzer.getFraudsByTypeCount(transactionList, TransactionType.TRANSFER.name()));
        System.out.println("- DEBIT: " + fraudAnalyzer.getFraudsByTypeCount(transactionList, TransactionType.DEBIT.name()));
        System.out.println("- PAYMENT: " + fraudAnalyzer.getFraudsByTypeCount(transactionList, TransactionType.PAYMENT.name()));
    }
}
