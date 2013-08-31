package homework;

import java.util.ArrayList;
import java.util.List;

public class Queue {
	private ArrayList<Customer> customerQueue = new ArrayList<Customer>();
	
	public void enQueue(Customer customer){
		customerQueue.add(customer);
	}
	
	public Customer deQueue(){
		return customerQueue.remove(0);
	}
	
	public Customer getCustomer(int index){
		return customerQueue.get(index);
	}
	
	public boolean isEmpty(){
		if(customerQueue.size()==0){
			return true;
		}
		else return false;
	}
	
	public int getNumberOfCustomer(){
		return this.customerQueue.size();
	}
	
	//test
	List<Customer> getList() {
		return customerQueue;
	}
}
