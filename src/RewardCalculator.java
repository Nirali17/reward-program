
import java.util.List;

public class RewardCalculator {

/**
 * ==============================================================
 * Reward Points Calculation:
 * ==============================================================
 * Purchase Points:
 * 		Upto $.50     = No points on Each Dollar
 * 		$.50 - $.100  = 1 Point on Each Dollar
 * 		Above $.100 = 2 Points on Each Dollar
 * --------------------------------------------------------------
 * Example: $. 120 Purchase = 1 * $.50 + 2 * $.20 = 90 Points
 * --------------------------------------------------------------				
 */
	
  public int rewardCalculator(double purchase) {
	 int points = 0;
	 if(purchase > 100) {
		 purchase = purchase - 100;
		 points = (int) (purchase) * 2  // 2 Points on Each Dollar above $.100
				 				  + 50; // 1 point on each dollar in between $.50 - $.100
	 } 
	 else if(purchase > 50 && purchase<100) {
		 purchase = purchase - 50;
		 points = (int) purchase; // 50 Points (1 Point on Each Dollar)
	 }
	 return points;
  }
  
  public void sortCustomerTransactions(List<TransactionRecord> transactionRecordList) {
	  CalendarManager calendarManager = new CalendarManager();
	    long tempCustomerId = 0;
	    String tempMonth = "";
	    double totalSpentPerMonth = 0.0;
	    int totalRewardPointsPerMonth = 0;
		for(TransactionRecord transactionRecord : transactionRecordList){ 
			long transactionId = transactionRecord.getTransactionId();
			String date = transactionRecord.getDate();
			String month = calendarManager.getMonthName(Integer.parseInt(date.split("/")[1])-1);
			long customerId = transactionRecord.getCustomerId();
			String customerName = transactionRecord.getCustomerName();
			double purchase = transactionRecord.getPurchase();
			String purchased = transactionRecord.getPurchased();
			int rewardPoints = rewardCalculator(purchase);
			
			if(tempCustomerId == 0 || tempCustomerId != customerId) {
				tempCustomerId = customerId;
				if(totalSpentPerMonth >0) {
				   System.out.println("Total Transactions for "+tempMonth+" : "+totalSpentPerMonth);
				   System.out.println("Total Reward Points for "+tempMonth+" : "+totalRewardPointsPerMonth);
				}
				totalSpentPerMonth = 0.0;
				totalRewardPointsPerMonth = 0;
				tempMonth = "";
				System.out.println("");
				System.out.println("====================================================");
				System.out.println("Customer Id: "+customerId+"  CustomerName : "+customerName);
				System.out.println("====================================================");
			}
			if(tempMonth.isEmpty() || !tempMonth.equalsIgnoreCase(month)) {
				if(totalSpentPerMonth >0) {
					System.out.println("Total Transactions for "+tempMonth+" : "+totalSpentPerMonth);
					System.out.println("Total Reward points for "+tempMonth+" : "+totalRewardPointsPerMonth);
				}
				tempMonth = month;
				totalSpentPerMonth = 0.0;
				totalRewardPointsPerMonth = 0;
				System.out.println("");
				System.out.println("          "+month.toUpperCase()+" MONTH TRANSACTIONS");
				System.out.println("");
			}
			if(tempCustomerId == customerId) {
				 System.out.println("----------------------------------------------------");
				 System.out.println("Transaction Id : "+transactionId);
				 System.out.println("----------------------------------------------------");
				 System.out.println("Date Id : "+date+"    Purchased : "+purchased);
				 System.out.println("Amount : "+purchase+"   Reward points  :  "+rewardPoints);
				 System.out.println("----------------------------------------------------");
				 System.out.println("");
				 totalSpentPerMonth+=purchase;
				 totalRewardPointsPerMonth+=rewardPoints;	 
			}
		}
		if(totalSpentPerMonth >0) {
		  System.out.println("Total Transactions for "+tempMonth+" : "+totalSpentPerMonth);
		  System.out.println("Total Reward Points for "+tempMonth+" : "+totalRewardPointsPerMonth);
		}
  }
	
}
