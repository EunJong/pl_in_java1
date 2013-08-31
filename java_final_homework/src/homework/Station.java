package homework;

import java.util.ArrayList;
import java.util.HashMap;

public class Station {

	public static int employeeIndex = 0;
	Queue stationLobbyQueue = new Queue();
	int numberOfEmployee = 3;
	ArrayList<Employee> employeeList = new ArrayList<Employee>();
	ShortestTimeMatrix timeTable = new ShortestTimeMatrix();
	HashMap<String, Integer> city = new HashMap<String, Integer>();
	boolean flag = true;
	Strategy strategy;
	
	private static Station station = new Station();
	
	public static Station getInstance(){
		return station;
	}
	
	private Station(){
		for(int i=0; i < numberOfEmployee; i++)
			employeeList.add(new Employee());
		
		timeTable.setShortestTimeTable();
		setCityInfo();
	}
	
	private void setCityInfo() {
		city.put("Seoul", 0);
		city.put("Chuncheon", 1);
		city.put("Wonju", 2);
		city.put("Asan", 3);
		city.put("Kyungju", 4);
		city.put("Deajeon", 5);
		city.put("Gwangju", 6);
	}

	public void enQueueCustomerToLobby() {

		if(Home.getInstance().customersAtHome.isEmpty()) return;
		
		for(int i=0; i < Home.getInstance().customersAtHome.getNumberOfCustomer(); i++){
			
			if(Home.getInstance().customersAtHome.getCustomer(i).getStationArrivalTime() == TicketingMain.CURRENT_TIME) {
				stationLobbyQueue.enQueue(Home.getInstance().customersAtHome.deQueue());
				i--;
			}

			else if(Home.getInstance().customersAtHome.getCustomer(i).getStationArrivalTime() > TicketingMain.CURRENT_TIME)
				break;
		}
	}
	
	public void enQueueCustomerInLobbyToTicketingBox(){
		
		if(Station.getInstance().stationLobbyQueue.isEmpty()) return;
		
		for(int i=0; i<Station.getInstance().stationLobbyQueue.getNumberOfCustomer(); i++){
			Station.getInstance().stationLobbyQueue.getCustomer(i).setWaitingTime(employeeList.get(strategy.chooseEmployeeIndex()).getTotalWaitingTime());
			employeeList.get(strategy.chooseEmployeeIndex()).customerQueue.enQueue(Station.getInstance().stationLobbyQueue.deQueue());
			i--;
		}
	}

	public void chooseStrategy(int strategyNumber) {
		if(strategyNumber==1)
			strategy = new RoundRobin();
		else if(strategyNumber==2)
			strategy = new LeastQueueWaiting();
		else
			System.out.println("제대로된 값을 입력하세요. 전략을 선택하지 않으면 진행할 수 없습니다.");
	}

}
