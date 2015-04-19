
public class IsingModel {
	private class block{

		private int orientation;
		
		public block(){
			orientation = 0;
		}
	}
	
	private block [][] state;
	
	public IsingModel(int n){
		state = setState(n);//square default size = 10
	}
	public IsingModel(int [][] matrix){
		state = setState(matrix);//square default size = 10
	}
	private block[][] setState(int n) {
		state = new block[n][n];
		for(int i = 0; i < state.length; i ++){
			for(int j = 0; j <state[0].length; j ++){
				state[i][j] = new block();
				//state[i][j].ID = ""+cellTypes.A;
				state[i][j].orientation = (int) (Math.random()*2);
			}
		}
		return state;
	}
	
	private block[][] setState(int [][] matrix) {
		state = new block[matrix.length][matrix[0].length];
		for(int i = 0; i < state.length; i ++){
			for(int j = 0; j <state[0].length; j ++){
				state[i][j] = new block();
				//state[i][j].ID = ""+cellTypes.A;
				state[i][j].orientation = matrix[i][j];
			}
		}
		return state;
	}
	
	@Override
	public String toString(){
		String result = "";
		for(int i = 0; i < state.length; i++){
			for(int j = 0; j < state[0].length; j++){
				result += state[i][j].orientation;
			}
			result+="\n";
		}
		return result;
	}
	
	public int getOrientation(int x, int y){
		return state[x][y].orientation;
	}
	
	public void setOrientation(int x, int y, int newOrientation){
		state[x][y].orientation = newOrientation;
	}
	
	public int[] getNeighborList(int x, int y){
		int neighbors[] = new int[8];
		int length = 0;
		for(int i = x-1; i < x+2; i++){
			for (int j = y-1; j < y+2; j++){
				if(!(x==i && y==j)){
					int xtemp = (i+state.length)%state.length;
					int ytemp = (j+state[0].length)%state[0].length;
					neighbors[length] = getOrientation(i,j);
					length++;
				} 
			}
		}
		return neighbors;
	}
	
	

}
