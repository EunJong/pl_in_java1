package homework;

public class Customer {
	private int ID;							// �� ���̵�
	private String name;					// �� �̸�
	private int stationArrivalTime;			// ���� �����ϴ� �ð�
	private int ticketingTime;				// Ƽ���� �ҿ�ð�
	private String departureStation;		// ��߿�
	private String arrivalStation;			// ������
	private int waitingTime = 0;			// ���ð�
	private int travelTime = 0;				// ���������� ���� �� �ɸ��� �ð�
	private int destinationArrivalTime = 0;	// ���� �����ð�
	
	public int getID() {
		return ID;
	}
	
	public String getName() {
		return name;
	}

	public int getStationArrivalTime() {
		return stationArrivalTime;
	}

	public int getTicketingTime() {
		return ticketingTime;
	}

	public String getDepartureStation() {
		return departureStation;
	}

	public String getArrivalStation() {
		return arrivalStation;
	}

	public int getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}

	public int getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(int travelTime) {
		this.travelTime = travelTime;
	}

	public int getDestinationArrivalTime() {
		return destinationArrivalTime;
	}

	public void setDestinationArrivalTime(int destinationArrivalTime) {
		this.destinationArrivalTime = destinationArrivalTime;
	}
	
	Customer(int ID, String name, int stationArrivalTime, int ticketingTime, String departureStation, String arrivalStation){
		this.ID = ID;
		this.name = name;
		this.stationArrivalTime = stationArrivalTime;
		this.ticketingTime = ticketingTime;
		this.departureStation = departureStation;
		this.arrivalStation = arrivalStation;
	}
	
	public String toString(){
		// ���� : 1�� ��2001�Բ����� Seoul������ ����� 16�� ���� Chuncheon���� �����ϼ̽��ϴ�.
		return ID+"�� "
				+ name+"�Բ����� "
				+ stationArrivalTime+"�п� ���� �����ؼ� "
				+ waitingTime+"�� ���� ��ٷȴٰ� "
				+ ticketingTime+"�� ���� ǥ�� ���� ���� "
				+ departureStation+"������ ����� "
				+ travelTime+"�� �� �������� "
				+ arrivalStation+"���� �����ϼ̽��ϴ�. "
				+ "�����ð��� "+destinationArrivalTime+"�� �Դϴ�.";
	}
}
