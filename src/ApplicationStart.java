import java.util.List;

public class ApplicationStart {
  public static void main(String args[]) {
	List<TransactionRecord> transactionRecordList = new TransactionManager().getListOfTransactionRecords();
	new RewardCalculator().sortCustomerTransactions(transactionRecordList);
  }
}
