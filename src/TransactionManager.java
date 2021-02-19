import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TransactionManager {
	
	public List<TransactionRecord> getListOfTransactionRecords() {
		List<TransactionRecord> transactionRecordList = new ArrayList<TransactionRecord>();
	    try {
	      File myObj = new File(System.getProperty("user.dir")+"\\Transactions.csv");
	      Scanner myReader = new Scanner(myObj);
	      int index = 0;
	      while (myReader.hasNextLine()) {
	        String line = myReader.nextLine();
	        if(index>0) {
	        	TransactionRecord transactionRecord = new TransactionRecord();
	        	String[] columns = line.split(",");
	        	transactionRecord.setTransactionId(Long.parseLong(columns[0]));
	        	transactionRecord.setDate(columns[1]);
	        	transactionRecord.setCustomerId(Long.parseLong(columns[2]));
	        	transactionRecord.setCustomerName(columns[3]);
	        	transactionRecord.setPurchase(Double.parseDouble(columns[4]));
	        	transactionRecord.setPurchased(columns[5]);
	        	transactionRecordList.add(transactionRecord);
	        }
	        index++;
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	    
	    return transactionRecordList.stream().sorted(Comparator.comparingLong(TransactionRecord::getCustomerId))
	    			.collect(Collectors.toList());
	  }
	
}
