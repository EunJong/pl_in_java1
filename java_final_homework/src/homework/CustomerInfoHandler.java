package homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CustomerInfoHandler {
	ArrayList<String> customerInfo = new ArrayList<String>();

	public void loadCustomerInfo(String filePath) throws IOException{

		BufferedReader br = new BufferedReader(new FileReader(filePath));
		
		String str;
		while((str = br.readLine()) != null){
			customerInfo.add(str);
		}
		
		br.close();
	}
	
	public void createCustomer(){
		for(int i=1; i < customerInfo.size(); i++){
			String[] customerInfoList = customerInfo.get(i).split("	");
			
			int id = Integer.parseInt(customerInfoList[0]);
			String name = customerInfoList[1];
			int stationArrivalTime = Integer.parseInt(customerInfoList[2]);
			int ticketingTime = Integer.parseInt(customerInfoList[3]);
			String departureStation = customerInfoList[4];
			String arrivalStation = customerInfoList[5];
			
			Customer customer = new Customer(id, name, stationArrivalTime, ticketingTime, departureStation, arrivalStation);
			Home.getInstance().setCustomers(customer);
		}
	}
	
	public void printResult() throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt"));
		
		while(!Train.getInstance().destinationQueue.isEmpty()){
			bw.write(Train.getInstance().destinationQueue.deQueue().toString() + System.getProperty("line.separator"));
			bw.flush();
		}
		
		
		bw.close();
	}
//	public void saveTicketingResult() throws IOException{
//		
//	}
}
