package homework;

public class Employee {
	Queue customerQueue = new Queue();
	public boolean flag = false;
	
	public void ticketing(){
		
		if(customerQueue.isEmpty()) return;
		
		for(int i=0; i < customerQueue.getNumberOfCustomer(); i++){
			
			if(customerQueue.getCustomer(i).getStationArrivalTime() 
					+ customerQueue.getCustomer(i).getWaitingTime()
					+ customerQueue.getCustomer(i).getTicketingTime()
					<= TicketingMain.CURRENT_TIME){

				customerQueue.getCustomer(i).setTravelTime(getShortestPathTime(customerQueue.getCustomer(i)));
				Customer cus = customerQueue.deQueue();
				Train.getInstance().passengerQueue.enQueue(cus);
				i--;
			}
		}
	}
	
	public int getTotalWaitingTime() {
		int result = 0;
		for(int i=0; i < customerQueue.getNumberOfCustomer(); i++){
			result = result + customerQueue.getCustomer(i).getTicketingTime();
		}
		return result;
	}
	
	private int getShortestPathTime(Customer customer) {
		String departureStation = customer.getDepartureStation();
		String arrivalStation = customer.getArrivalStation();
		
		int departureStationID = Station.getInstance().city.get(departureStation);
		int arrivalStationID = Station.getInstance().city.get(arrivalStation);
				
		return Station.getInstance().timeTable.getShortestTime(departureStationID, arrivalStationID);
	}
	
}
