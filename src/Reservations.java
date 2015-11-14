import java.util.Scanner;

public class Reservations {
// PRIVATE VARIABLES +++++++++++++++++++++++++
	private int[] _seat;
	private int[] _firstClassSeat;
	private int[] _economyClassSeat;
	private int _minFirstClassSeat;
	private int _minEconomySeat;
	private int _maxFirstClassSeat;
	private int _maxEconomySeat;
	private int _reserveSeat;
	
	
	private boolean F = true;
	private boolean E = true;
	private boolean thisFlight = true;
	
	// CONSTRUCTOR +++++++++++++++++++++++++
	public Reservations(){
		_initialize();
	}

	// PRIVATE METHODS ++++++++++++++++++++++++
	private void _initialize() {
		
		this._seat = new int[10];
		for (int i =0; i<this._seat.length; i++ ){
		this._seat[i]= 0;	
		}
		
		this._firstClassSeat = new int[this._maxFirstClassSeat - this._minFirstClassSeat];
		for (int i =this._minFirstClassSeat; i<this._maxFirstClassSeat; i++){
			for (int j =0; j<this._firstClassSeat.length; j++){
			this._firstClassSeat[j] = this._seat[i];
			}
		}
		
		this._economyClassSeat = new int[this._maxEconomySeat - this._minEconomySeat];
		for (int i =this._minEconomySeat; i<this._maxEconomySeat; i++){
			for (int j =0; j<this._economyClassSeat.length; j++){
			this._economyClassSeat[j] = this._seat[i];
			}
		}
		this._minFirstClassSeat = 0;
		this._minEconomySeat = 6;
		this._maxFirstClassSeat=5;
		this._maxEconomySeat = 10;
	}
	
// PUBLIC METHODS +++++++++++++++++++++++++++++++++++++++++
	public void menu(){
		
		System.out.println("Please select one option:");
		System.out.println("1- First Class");
		System.out.println("2- Economy Class");
		System.out.println("3- Exit");
	}
	

	public void Selection(){
		if(thisFlight==true){
		while(F||E){
			if(thisFlight==true){
		menu();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		switch(num){
		case 1:
				firstClass();
					Selection();
			
		case 2:
				economyClass();
				Selection();
		
		case 3:
			thisFlight = false;
		
			break;
		default:
				break;

		  }
		}
	}
		}
	}
	
	public void firstClass(){
	
		boolean breakLoop = false;
		int j =0;
 
		    	  while(!breakLoop){
		    		  j++;
		    		  if((j<=this._maxFirstClassSeat)){
			  if(this._seat[j-1]==0){
				this._reserveSeat = j;
				this._seat[j-1] = 1;
				
				System.out.printf("Your reserved seat is %d.%n", this._reserveSeat);
				 breakLoop = true;
			  }
			  else{
               
                 breakLoop = false;
			  }
		      }
		    		  else{
		    			  if (E==true)
		    			  System.out.println("The first class is full. please select the economy class.");
		    			  F = false;
		    			  breakLoop = true;
		    			  if(E==false && F==false && thisFlight==true){
		    					System.out.println("Sorry, this flight is full. Next flight leaves here 3 hours later. You can book next flight ticket from 2 hours before take off.");
		    					thisFlight = false;
		    			  }

		    			  
		    			Selection();
		    		  }
			}
	}
	
public void economyClass(){
		
	boolean breakLoop = false;
	int j =this._minEconomySeat-1;
	 while(!breakLoop){
		  j++;
		  if((j<=this._maxEconomySeat)){
 if(this._seat[j-1]==0){
	this._reserveSeat = j;
	this._seat[j-1] = 1;
	
	System.out.printf("Your reserved seat is %d.%n", this._reserveSeat);
	 breakLoop = true;
 }
 else{
  
    breakLoop = false;
 }
 }
		  else{
			 
			  if (F==true)
			  System.out.println("The economy class is full. please select the first class.");
			 E = false;
			 breakLoop = true;
			 if(E==false && F==false && thisFlight==true){
					System.out.println("Sorry, this flight is full. Next flight leaves here 3 hours later. You can book next flight ticket from 2 hours before take off.");
			  }
			  Selection();
		  }
}

}

}
	

