package bankStatement;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Month;
import java.nio.file.Path;
import java.util.List;


/**
 *
 * @author Kevon
 */
public class BankStatementAnalyzer {
    
    private static final String RESOURCES = "C:\\Users\\Kevon\\Downloads";
    
    
    public static void main(String args []) throws IOException
    {
    	
    final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
    final BankStatementParser bankStatementParser = new BankStatementCSVParser();
    
    bankStatementAnalyzer.analyze(args[0], bankStatementParser);
    
    
        
    }
    
    
    public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException
    {
    	
    	final Path path = Paths.get(RESOURCES, fileName);
    	final List<String> lines = Files.readAllLines(path);
    	
    	final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
    	final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
    	
    	// implement code for summary here!
    	
    	final SummaryStatistics summary = new SummaryStatistics(bankStatementProcessor.calculateTotalAmount(), 0, 0, 0);
    	
    	new CreateFileHTML("test",new HtmlExporter().export(summary));
    	 

    	System.out.println("The total for all transactions is "+ bankStatementProcessor.calculateTotalAmount());
    	
    	System.out.println("The total amount for january is "+ bankStatementProcessor.CalculateTotalInMonth(Month.JANUARY));
    	
    //	System.out.println("The total amount for febuary is "+ bankStatementProcessor.CalculateTotalInMonth(Month.FEBRUARY));
    	
    	System.out.println("The total Income received is " + bankStatementProcessor.CalculateTotalForCategory("Income"));
    	
    }
    
    
}
