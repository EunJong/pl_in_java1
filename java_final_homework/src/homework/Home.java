package homework;


public class Home {
	Queue customersAtHome = new Queue();
	
	private static Home home = new Home();
	
	private Home(){}
	
	public static Home getInstance(){
		return home;
	}
	
	public void setCustomers(Customer customer){
		customersAtHome.enQueue(customer);
	}
	
}