package bankStatement;
import java.util.List;
import java.util.ArrayList;
import java.time.*;
public class BankStatementProcessor {
	
	private final List<BankTransaction> bankTransactions;
	
	public BankStatementProcessor(final List<BankTransaction> bankTransactions) 
	{
		
		this.bankTransactions = bankTransactions;
		
	}
	
	
	public double calculateTotalAmount() // calculate statement total
	{
		double total = 0;
		for(final BankTransaction bankTransaction : bankTransactions) 
		{
			total += bankTransaction.getAmount();
			
		}
		return total;
		
	}
	
	public double CalculateTotalInMonth(final Month month)  // calculate total for given month
	{
		double total = 0;
		for(final BankTransaction bankTransaction : bankTransactions) 
		{
			if(bankTransaction.getDate().getMonth() == month) 
			{
				
				total += bankTransaction.getAmount();
			}
			
		}
		return total;
		
	}
	
	public double CalculateTotalForCategory(final String category)  // get total based on category(description)
	{
		
		double total =0;
		for(final BankTransaction bankTransaction : bankTransactions) 
		{
			if(bankTransaction.getDescription().equals(category)) 
			{
				total = bankTransaction.getAmount();
				
			}
			
		}
		return total;
		
		
	}
	
	public List<BankTransaction>findTransactions(final BankTransactionFilter bankTransactionFilter)
	{
		final List<BankTransaction> result = new ArrayList<>();
			for(final BankTransaction bankTransaction : bankTransactions) 
			{
				if(bankTransactionFilter.test(bankTransaction)) 
				{
					result.add(bankTransaction);
					
				}
				
				
			}
		return bankTransactions;
		
	}
	
	
	public List<BankTransaction>findTransactionsGreaterThanEqual(final int amount)
	{
		return findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount);
		
		
	}
	
	public double summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer) 
	{
		
		double result = 0;
		for(final BankTransaction bankTransaction : bankTransactions)
		{
			result = bankTransactionSummarizer.summarize(result, bankTransaction);
			
			
			
		}
		return result;
		
	}
	

}
