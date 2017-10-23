package remakeLogicAndGUI;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class BoardGUI {

	int numberOfRows;
	int numberOfColumns;
	CoordinateTile[][] board;
	int numberOfPlayers;
	ArrayList<PlayerController> allPlayers;
	Color[] allColours = {Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW,Color.MAGENTA,Color.CYAN,Color.ORANGE,Color.GRAY};
	
	BoardGUI(int m, int n, int numberOfPlayers)
	{
		this.numberOfRows = m;
		this.numberOfColumns = n;
		this.numberOfPlayers = numberOfPlayers;
		board = new CoordinateTile[this.numberOfRows][this.numberOfColumns];
		
		for(int i=0;i<this.numberOfRows;i+=1)
		{
			for(int j=0;j<this.numberOfColumns;j+=1)
			{
				if(this.numberOfRows==9)
				{
					this.board[i][j] = new CoordinateTile(i,j,this.numberOfRows,this.numberOfColumns,this,50);
				}
				else
				{
					this.board[i][j] = new CoordinateTile(i,j,this.numberOfRows,this.numberOfColumns,this,40);
				}
			}
		}
		
		this.allPlayers = new ArrayList<PlayerController>();
		for(int i=0;i<numberOfPlayers;i+=1)
		{
			PlayerController p = new PlayerController(i+1,allColours[i]);
			allPlayers.add(p);
		}
	}
	
	public boolean checkValidCoordinate(int i, int j)
	{
		if(i>=0 && i<this.numberOfRows && j>=0 && j<this.numberOfColumns)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public ArrayList<CoordinateTile> getListOfNeighbours(int i, int j)
	{
		ArrayList<CoordinateTile> allNeighbours = new ArrayList<CoordinateTile>();
		if(this.checkValidCoordinate(i, j+1))
		{
			allNeighbours.add(this.board[i][j+1]);
		}
		if(this.checkValidCoordinate(i, j-1))
		{
			allNeighbours.add(this.board[i][j-1]);
		}
		if(this.checkValidCoordinate(i+1, j))
		{
			allNeighbours.add(this.board[i+1][j]);
		}
		if(this.checkValidCoordinate(i-1, j))
		{
			allNeighbours.add(this.board[i-1][j]);
		}
		return allNeighbours;
	}
	
	public int playerCount(int playerStatus)
	{
		int count = 0;
		for(int i=0;i<this.numberOfRows;i+=1)
		{
			for(int j=0;j<this.numberOfColumns;j+=1)
			{
				if(this.board[i][j].playerStatus==playerStatus)
				{
					count+=this.board[i][j].value;
				}
			}
		}
		return count;
	}
	
	public int countEmptyCells()
	{
		int count = 0;
		for(int i=0;i<this.numberOfRows;i+=1)
		{
			for(int j=0;j<this.numberOfColumns;j+=1)
			{
				if(this.board[i][j].value==0)
				{
					count+=1;
				}
			}
		}
		return count;
	}
	
	public int countAllActivePlayers(ArrayList<PlayerController> allPlayers)
	{
		int count = 0;
		for(int i=0;i<allPlayers.size();i+=1)
		{
			if(allPlayers.get(i).active)
			{
				count+=1;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
