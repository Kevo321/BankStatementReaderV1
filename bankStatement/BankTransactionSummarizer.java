package bankStatement;

public interface BankTransactionSummarizer {

	double summarize(double accumulator, BankTransaction bankTransaction);
}
