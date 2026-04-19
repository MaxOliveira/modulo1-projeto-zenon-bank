package br.com.zenon;

import java.math.BigDecimal;

public record Transaction(Integer step, String type, BigDecimal amount, String nameOrig, BigDecimal oldbalanceOrg,
                          BigDecimal newbalanceOrig, String nameDest, BigDecimal oldbalanceDest, BigDecimal newbalanceDest,
                          int isFraud, int isFlaggedFraud) {

    public Transaction {
        validatePositiveInteger(step);
        validateNonEmptyString(type, "Type");
        validateTransactionType(type);
        validateNonNegativeBigDecimal(amount, "Amount");
        validateNonEmptyString(nameOrig, "NameOrig");
        validateNonNegativeBigDecimal(oldbalanceOrg, "OldbalanceOrg");
        validateNonNegativeBigDecimal(newbalanceOrig, "NewbalanceOrig");
        validateNonEmptyString(nameDest, "NameDest");
        validateNonNegativeBigDecimal(oldbalanceDest, "OldbalanceDest");
        validateNonNegativeBigDecimal(newbalanceDest, "NewbalanceDest");
        validateBinaryFlag(isFraud, "IsFraud");
        validateBinaryFlag(isFlaggedFraud, "IsFlaggedFraud");
    }

    private static void validatePositiveInteger(Integer value) {
        if (value == null || value < 1) {
            throw new IllegalArgumentException("Step must be notNull and positive: " + value);
        }
    }

    private static void validateNonEmptyString(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " must be notNull and non-empty: " + value);
        }
    }

    private static void validateTransactionType(String type) {
        try {
            TransactionType.valueOf(type);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Type must be a valid TransactionType: " + type, e);
        }
    }

    private static void validateNonNegativeBigDecimal(BigDecimal value, String fieldName) {
        if (value == null) {
            throw new NumberFormatException(fieldName + " must be notNull");
        }
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(fieldName + " must be notNull and positive: " + value);
        }
    }

    private static void validateBinaryFlag(int value, String fieldName) {
        if (value != 0 && value != 1) {
            throw new IllegalArgumentException(fieldName + " must be either 0 or 1: " + value);
        }
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "step=" + step +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", nameOrig='" + nameOrig + '\'' +
                ", oldbalanceOrg=" + oldbalanceOrg +
                ", newbalanceOrig=" + newbalanceOrig +
                ", nameDest='" + nameDest + '\'' +
                ", oldbalanceDest=" + oldbalanceDest +
                ", newbalanceDest=" + newbalanceDest +
                ", isFraud=" + isFraud +
                ", isFlaggedFraud=" + isFlaggedFraud +
                '}';
    }
}
