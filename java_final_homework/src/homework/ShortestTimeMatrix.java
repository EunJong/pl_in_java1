package homework;

public class ShortestTimeMatrix {
	int noPath = 9999;
	
	int adjacencyMatrix[][] = {
			{0, 16, 22, 20, noPath, 29, noPath},
			{16, 0, 28, noPath, 31, noPath, noPath},
			{22, 28, 0, noPath, 32, 23, noPath},
			{20, noPath, noPath, 0, noPath, 35, 25},
			{noPath, 31, 32, noPath, 0, 15, 18},
			{29, noPath, 23, 35, 15, 0, 12},
			{noPath, noPath, noPath, 25, 18, 12, 0}};
	
	public void setShortestTimeTable(){

		for(int mid=0; mid < 7; mid++){
			for(int start=0; start < 7; start++){
				for(int end=0; end < 7; end++){
					if(adjacencyMatrix[start][mid] + adjacencyMatrix[mid][end] < adjacencyMatrix[start][end]){
						adjacencyMatrix[start][end] = adjacencyMatrix[start][mid] + adjacencyMatrix[mid][end];
					}
				}
			}
		}
	}
	
	public int getShortestTime(int start, int end){
		return adjacencyMatrix[start][end];
	}
	
}
