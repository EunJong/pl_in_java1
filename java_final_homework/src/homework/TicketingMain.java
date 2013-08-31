package homework;

import java.io.IOException;
import java.util.Scanner;

public class TicketingMain {
	public static int CURRENT_TIME = 0;
	final static String CUSTOMER_INFO_FILE_NAME = "customerInfo.txt";
	
	public static void main(String[] args) throws IOException {
		CustomerInfoHandler customerInfoHandler = new CustomerInfoHandler();
		customerInfoHandler.loadCustomerInfo(CUSTOMER_INFO_FILE_NAME);
		customerInfoHandler.createCustomer();
		
		System.out.println("Ticketing Main Start~!");
		
		System.out.println("전략을 선택하세요. (1 or 2)");
		System.out.println("1. Round Robin");
		System.out.println("2. Least Queue Waiting");

		Scanner scanner = new Scanner(System.in);
		int inputStrategy = Integer.parseInt(scanner.next());
		Station.getInstance().chooseStrategy(inputStrategy);
		
		while(Station.getInstance().flag){
			Station.getInstance().enQueueCustomerToLobby();
			Station.getInstance().enQueueCustomerInLobbyToTicketingBox();
			for(int i=0; i < Station.getInstance().numberOfEmployee; i++)
				Station.getInstance().employeeList.get(i).ticketing();
			Train.getInstance().goTrain();

			CURRENT_TIME++;
		}
		
//		System.out.println("time : " + CURRENT_TIME);
//		System.out.println("home : " + Home.getInstance().customersAtHome.getNumberOfCustomer());
//		System.out.println("station : " + Station.getInstance().stationLobbyQueue.getNumberOfCustomer());
//		System.out.println("employee : " + Station.getInstance().employeeList.get(0).customerQueue.getNumberOfCustomer());
//		System.out.println("train : " + Train.getInstance().passengerQueue.getNumberOfCustomer());
//		System.out.println("dst : " + Train.getInstance().destinationQueue.getNumberOfCustomer());
//		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++\n");
		
		customerInfoHandler.printResult();
		System.out.println("Ticketing Main End~!");
		
	}
}