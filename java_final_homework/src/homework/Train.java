package homework;

public class Train {
	Queue passengerQueue = new Queue();
	Queue destinationQueue = new Queue();
	
	private static Train train = new Train();
	
	private Train(){}
	
	public static Train getInstance(){
		return train;
	}
	
	public void goTrain(){
		if(TicketingMain.CURRENT_TIME % 5 == 0){
			for(int i=0; i<Train.getInstance().passengerQueue.getNumberOfCustomer(); i++){
				Customer passenger = passengerQueue.deQueue();
				i--;
				passenger.setDestinationArrivalTime(passenger.getTravelTime() + TicketingMain.CURRENT_TIME);
				destinationQueue.enQueue(passenger);
			}
		}
		if(destinationQueue.getNumberOfCustomer() >= 50){
			Station.getInstance().flag = false;
		}
			
	}
}
