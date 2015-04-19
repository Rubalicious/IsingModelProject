import static org.junit.Assert.*;

import org.junit.Test;


public class IsingModelTest {

	@Test
	public void test() {
		IsingModel board = new IsingModel(10);
		System.out.println(board.toString());
	}
	
	@Test
	public void testSetStateAndGetOrientation(){
		int [][] state = {		{1,0,1},
								{0,0,1},
								{0,1,1}			};
		IsingModel board = new IsingModel(state);
		
		assertEquals(1, board.getOrientation(0, 0));
		assertEquals(0, board.getOrientation(0, 1));
		assertEquals(1, board.getOrientation(0, 2));
		
		assertEquals(0, board.getOrientation(1, 0));
		assertEquals(0, board.getOrientation(1, 1));
		assertEquals(1, board.getOrientation(1, 2));
		
		assertEquals(0, board.getOrientation(2, 0));
		assertEquals(1, board.getOrientation(2, 1));
		assertEquals(1, board.getOrientation(2, 2));
	}
	
	@Test
	public void testGetNeighbors(){
		int [][] state = {		{1,0,1,0},
								{0,0,1,1},
								{0,1,1,0},
								{0,1,0,0}		};
		IsingModel board = new IsingModel(state);
		
		int [] neighbors = {1,0,1,0,1,0,1,1};
		assertEquals(0, board.getOrientation(1, 1));
		assertEquals(neighbors, board.getNeighborList(1, 1));
		
		int [] neighbors1 = {0,1,0,0,1,1,1,0};
		assertEquals(1, board.getOrientation(1, 2));
		assertEquals(neighbors1, board.getNeighborList(1, 2));
	}
	
	@Test
	public void testGetNeighborsWithWrapAround(){
		int [][] state = {		{1,0,1,0},
								{0,0,1,1},
								{0,1,1,0},
								{0,1,0,0}		};
		IsingModel board = new IsingModel(state);
		
		int [] neighbors = {0,0,1,0,0,1,0,0};
		assertEquals(1, board.getOrientation(0, 0));
		assertEquals(neighbors, board.getNeighborList(0, 0));
		
		int [] neighbors1 = {1,1,0,1,0,0,1,0};
		assertEquals(1, board.getOrientation(3, 2));
		assertEquals(neighbors1, board.getNeighborList(3, 2));
	}

}
