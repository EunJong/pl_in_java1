package homework;

public class RoundRobin implements Strategy{
	
	@Override
	public int chooseEmployeeIndex() {
		Station.employeeIndex++;
		return Station.employeeIndex % 3;
	}

}
