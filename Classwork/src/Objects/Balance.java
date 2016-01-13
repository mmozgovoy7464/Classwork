package Objects;

public class Balance {
	
	private double amount;
	private long lastWorked;
	
	public double getAmount() {
		return Math.round(amount * 100.00) / 100.00;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getLastWorked() {
		return lastWorked;
	}
	public void setLastWorked(long lastWorked) {
		this.lastWorked = lastWorked;
	}
	
	public Balance(){
		amount = 0;
		lastWorked = 0;
	}
	public void subtractLateFees(long timeOverdue){
		if(timeOverdue < 0){
			amount += 1*timeOverdue/1000;
		}
	}
	public boolean canWork(long time){
		if(time-lastWorked > 10000 ){
			return true;
		}
		return false;
	}
	public String earnMoney(long time){
		if(canWork(time)){
			amount += 5;
			lastWorked = time;
			return "Did some work at the library and earned $5.";
		}
		return "Can not do a double shift! Wait until the first job is done!";
	}
}