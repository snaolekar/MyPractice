import java.util.Hashtable;
import java.util.Scanner;

/**
 * @author snaolekar
 *
 */
class Ships
{
	int id;
	int orientation ; // 0 represent horizontal, 1 represent vertical
	int size ;
	int status ; // 0 dead 1 alive
	int start[]= new int[2];
	int end[] = new int[2];
	Hashtable<String, String> propertyMapShip = new Hashtable<String, String>();
	
	//setter and getters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrientation() {
		return orientation;
	}
	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}
	public Hashtable<String, String> getPropertyMapShip() {
		return propertyMapShip;
	}
	public void setPropertyMapShip(Hashtable<String, String> propertyMapShip) {
		this.propertyMapShip = propertyMapShip;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int[] getStart() {
		return start;
	}
	public void setStart(int x1,int y1) {
		this.start[0] = x1;
		this.start[1]=y1;
	}
	public int[] getEnd() {
		return end;
	}
	public void setEnd(int x2, int y2) {
		this.end[0] = x2;
		this.end[1]=y2;
	}
	
}

class BoardTile // Tile class to have tile properties 
{
	boolean isShipPresent=false;
	boolean hit= false;
	Hashtable<String, String> propertyMapTile = new Hashtable<String, String>();
	
	//setter and getters
	
	public boolean isShipPresent() {
		return isShipPresent;
	}
	public boolean isHit() {
		return hit;
	}
	public void setHit(boolean hit) {
		this.hit = hit;
	}
	public void setShipPresent(boolean isShipPresent) {
		this.isShipPresent = isShipPresent;
	}
	public Hashtable<String, String> getPropertyMapTile() {
		return propertyMapTile;
	}
	public void setPropertyMapTile(Hashtable<String, String> propertyMapTile) {
		this.propertyMapTile = propertyMapTile;
	}
	
	
}

class Player
{
	String name;
	BoardTile board[][];
	Ships myships[];
	int credit;
	Hashtable<String, String> propertyMapPlayer = new Hashtable<String, String>();
	
	//constructor
	public Player(String name) {
		this.name = name;
	}
	
	//setter and getters
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BoardTile[][] getBoard() {
		return board;
	}
	public void setBoard(int N) {
		this.board = new BoardTile[N][N];
		initBoard();
	}
	public Ships[] getMyships() {
		return myships;
	}
	public void setMyships(int s) {
		this.myships = new Ships[s];
		initShips();
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public Hashtable<String, String> getPropertyMapPlayer() {
		return propertyMapPlayer;
	}
	public void setPropertyMapPlayer(Hashtable<String, String> propertyMapPlayer) {
		this.propertyMapPlayer = propertyMapPlayer;
	}
	void initShips()
	{
		for(int i=0;i<myships.length;i++)
		{
			this.myships[i]= new Ships();
		}
	}
	
	void initBoard()
	{
		for(int i=0;i<board[0].length;i++)
		{
			for(int j=0;j<board[0].length;j++)
			{
			this.board[i][j]= new BoardTile();
			}
		}
	}
	public void initShips(int id, int x1, int y1, int x2, int y2)
	{
		Ships currentShip= this.myships[id];
		currentShip.setId(id);
		currentShip.setStatus(1);
		currentShip.setStart(x1, y1);
		currentShip.setEnd(x2, y2);
		if(x1==x2)
		{
			//ship is vertical
			currentShip.setOrientation(1);
			currentShip.setSize((y2-y1));
			for(int i=y1; i<y2;i++)
			{
				this.board[x1][i].isShipPresent=true;
				this.board[x1][i].hit=false;	
			}
		}
		else if(y1==y2)
		{
			//ship is horizontal
			currentShip.setOrientation(0);
			currentShip.setSize((x2-x1));
			for(int i=x1; i<x2;i++)
			{
				this.board[i][y1].isShipPresent=true;
				this.board[i][y1].hit=false;
			}
		}
		
		
	}
	
	BoardTile getBoardTile(int x, int y)
	{
		return this.board[x][y];
	}
}

public class Battleshipgame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player player1= new Player("Player1");
		Player player2= new Player("Player2");
		
		Scanner input=new Scanner(System.in);
	    int n=input.nextInt(); 
	    int s=input.nextInt(); 
	    
		player1.setBoard(n);
		player2.setBoard(n);
		player1.setMyships(s);
		player2.setMyships(s);
		
		//initializing ships
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<s;j++)
			{
				//read input
				int x1= input.nextInt() , y1=input.nextInt() , x2=input.nextInt() , y2=input.nextInt() ;
				if(i==0)
				{
					player1.initShips(j, x1, y1, x2, y2);
				}
				else
				{
					player2.initShips(j, x1, y1, x2, y2);
				}
			}
		}
		
		//game begin
		while(true)
		{
			int turn =1;
			//input form user
			
			int x=input.nextInt() ;
			int y=input.nextInt() ;
			
			if(turn==1) //player 1 turn
			{
				BoardTile current = player2.getBoardTile(x,y);
				if(current.isShipPresent && !current.isHit())
				{
					System.out.println("This is a hit");
					current.setHit(true);
				}
				else
				{
					System.out.println("This is a miss");
				}
				
				Ships[] ships = player2.getMyships();
				int deadShipCount= 0;
				for(int i=0;i<ships.length;i++)
				{
					if(ships[i].getStatus()==1) //if ship is alive
					{
						for(int j=0;j<ships[i].getSize();j++)
						{
							boolean isShipAlive= false;
							if(ships[i].orientation==1)
							{
								int startx= ships[i].getStart()[0];
								int starty= ships[i].getStart()[1];
								if(!player2.getBoard()[startx+j][starty].isHit())
								{
									isShipAlive= true;
								}
							}
							else if(ships[i].orientation==0)
							{
								int startx= ships[i].getStart()[0];
								int starty= ships[i].getStart()[1];
								if(!player2.getBoard()[startx][starty+j].isHit())
								{
									isShipAlive= true;
								}
							}
							if(!isShipAlive)
							{
								System.out.println("ship"+j+"of player 2 is dead" );
								deadShipCount++;
							}
							
						}
					}
				}
				if(deadShipCount==s)
				{
					System.out.println("Player 1 win" );
					break;
				}
				turn=2;
			}
			else
			{
				if(turn==2) //player 2 turn
				{
					BoardTile current = player1.getBoardTile(x,y);
					if(current.isShipPresent && !current.isHit())
					{
						System.out.println("This is a hit");
						current.setHit(true);
					}
					else
					{
						System.out.println("This is a miss");
					}
					
					Ships[] ships = player1.getMyships();
					int deadShipCount= 0;
					for(int i=0;i<ships.length;i++)
					{
						if(ships[i].getStatus()==1) //if ship is alive
						{
							for(int j=0;j<ships[i].getSize();j++)
							{
								boolean isShipAlive= false;
								if(ships[i].orientation==1)
								{
									int startx= ships[i].getStart()[0];
									int starty= ships[i].getStart()[1];
									if(!player1.getBoard()[startx+j][starty].isHit())
									{
										isShipAlive= true;
									}
								}
								else if(ships[i].orientation==0)
								{
									int startx= ships[i].getStart()[0];
									int starty= ships[i].getStart()[1];
									if(!player2.getBoard()[startx][starty+j].isHit())
									{
										isShipAlive= true;
									}
								}
								if(!isShipAlive)
								{
									System.out.println("ship"+j+"of player 1 is dead" );
									deadShipCount++;
								}
								
							}
						}
					}
					if(deadShipCount==s)
					{
						System.out.println("Player 2 win" );
						break;
					}
				}
				turn=1;
			}
		}
		input.close();
	}

}
