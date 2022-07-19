package bankStatement;

import java.time.format.DateTimeFormatter;
//import java.util.Date;
import java.time.*;
import java.util.List;
import java.util.ArrayList;
public class BankStatementCSVParser implements BankStatementParser {
	
	
	private final static DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
	
	/*
	public List<BankTransaction> parseLinesFromCSV(final List<String> lines) 
	{
		
		/*dont forget to add code that will skip the first line in the column using 
		 * 
		 * bool firstLine = true;
		 * if(firstLine){firstline = false; continue;}
		 * this should skip the first line being parsed in a column and also make sure that a string value doesnt get parsed as a double
		 * 
		 * */
		
		
	 



	@Override
	public BankTransaction parseFrom(String line) {
		final String[] columns = line.split(",");
		final LocalDate date = LocalDate.parse(columns[1],DATE_PATTERN); // column 1 is the date column for Monzo bank
		final double amount = Double.parseDouble(columns[7]); // column 7 is responsible for Amount on monzo/ testing 1 using bankstatment-simple
		final String description = columns[6]; // testing index at 2 using 'bankStatement-simple.csv //[6] for monzo
		
		return new BankTransaction(date,amount,description);
	}


	@Override
	public List<BankTransaction> parseLinesFrom(List<String> lines) {
		final List<BankTransaction> bankTransactions = new ArrayList<>();
		boolean firstLine = true;
		for(final String line : lines) 
		{
			/*add validation code inorder to validate laines before they are parsed.
			 *
			 * 
			 * 
			 */
			 
			if(firstLine) 
			{
				firstLine = false;
				continue;
			} 
			bankTransactions.add(parseFrom(line));
			
			
		}
	return bankTransactions;
	
	}
	
	

}
