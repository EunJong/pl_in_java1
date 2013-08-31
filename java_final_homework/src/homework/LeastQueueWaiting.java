package homework;

import java.util.ArrayList;
import java.util.Collections;

public class LeastQueueWaiting implements Strategy {

	ArrayList<Integer> waitingTimeList = new ArrayList<Integer>();
	
	@Override
	public int chooseEmployeeIndex() {
		for(int i=0; i<Station.getInstance().numberOfEmployee; i++){
			waitingTimeList.add(Station.getInstance().employeeList.get(i).getTotalWaitingTime());
		}
		
		for(int i=0; i<Station.getInstance().numberOfEmployee; i++){
			if(waitingTimeList.get(i) == Collections.min(waitingTimeList)){
				waitingTimeList.removeAll(waitingTimeList);
				return i;
			}
		}
		
		return 0;
	}
}
