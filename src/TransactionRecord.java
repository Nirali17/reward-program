
public class TransactionRecord {
	long transactionId;
	String date;
	long customerId;
	String customerName;
	double purchase;
	String purchased;
	
	 @Override
     public String toString() {
         return "TransactionRecord(" +
                 "transactionId='" + transactionId +
                 ", date=" + date +
                 ", customerId=" + customerId +
                 ", customerName=" + customerName +
                 ", Purchase=" + purchase +
                 ", purchased=" + purchased +
                 ')';
     }
	
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getPurchase() {
		return purchase;
	}
	public void setPurchase(double purchase) {
		this.purchase = purchase;
	}
	public String getPurchased() {
		return purchased;
	}
	public void setPurchased(String purchased) {
		this.purchased = purchased;
	}
}
