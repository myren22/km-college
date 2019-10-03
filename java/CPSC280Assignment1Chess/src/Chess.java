
public class Chess {
	//define each pieces movement criteria
		//check from the piece moving out whether a space is occupied
		//if occupied check if king of opposing side
			//if king return piece type char.(color is represented by upper(white) and lower(black) case)
		//if occupied but not king stop checking moves past this pieces position
		//stop when reaching the end of board
	public static char getPawn(char[][] board1){
		for(int i=0; i<board1.length; i++){
			for(int g=0; g<board1[0].length; g++){
				//check if black pawn
				if(board1[i][g]=='p'){
					//check tiles below
						//make sure not pointing off board though
					int x=g;
					int y=i;
					if(x+1<board1.length && y+1<board1.length){
						if(board1[y+1][x+1]=='K'){
							return 'p';
						}
					}
					if(x-1>-1 && y+1<board1.length){
						if(board1[y+1][x-1]=='K'){
							return 'p';
						}
					}
						
				}
				if(board1[i][g]=='P'){
					//check tiles below
						//make sure not pointing off board though
					int x=g;
					int y=i;
					if(x+1<board1.length && y-1>-1){
						if(board1[y-1][x+1]=='k'){
							return 'P';
						}
					}
					if(x-1>-1 && y-1>-1){
						if(board1[y-1][x-1]=='k'){
							return 'P';
						}
					}
						
				}
				//check if white pawn
			}
		}
		return '-';
	}
	
	public static char getKnight(char[][] board1){
		for(int i=0; i<board1.length; i++){
			for(int g=0; g<board1[0].length; g++){
				//check if black knight
				if(board1[i][g]=='n'){
					
					int x=g;
					int y=i;
					//check tiles below
					if(x+1<board1.length && y+2<board1.length){
						if(board1[y+2][x+1]=='K'){
							return 'n';
						}
					}
					if(x-1>-1 && y+2<board1.length){
						if(board1[y+2][x-1]=='K'){
							return 'n';
						}
					}
					//check top
					if(x+1<board1.length && y-2>-1){
						if(board1[y-2][x+1]=='K'){
							return 'n';
						}
					}
					if(x-1>-1 && y-2>-1){
						if(board1[y-2][x-1]=='K'){
							return 'n';
						}
					}
					//check right
					if(x+2<board1.length && y-1>-1){
						if(board1[y-1][x+2]=='K'){
							return 'n';
						}
					}
					if(x+2<board1.length && y+1<board1.length){
						if(board1[y+1][x+2]=='K'){
							return 'n';
						}
					}
					//check left
					if(x-2>-1 && y-1>-1){
						if(board1[y-1][x-2]=='K'){
							return 'n';
						}
					}
					if(x-2>-1 && y+1<board1.length){
						if(board1[y+1][x-2]=='K'){
							return 'n';
						}
					}
				}
				
				//check if white knight
				if(board1[i][g]=='N'){
					
					int x=g;
					int y=i;
					//check tiles below
					if(x+1<board1.length && y+2<board1.length){
						if(board1[y+2][x+1]=='k'){
							return 'N';
						}
					}
					if(x-1>-1 && y+2<board1.length){
						if(board1[y+2][x-1]=='k'){
							return 'N';
						}
					}
					//check top
					if(x+1<board1.length && y-2>-1){
						if(board1[y-2][x+1]=='k'){
							return 'N';
						}
					}
					if(x-1>-1 && y-2>-1){
						if(board1[y-2][x-1]=='k'){
							return 'N';
						}
					}
					//check right
					if(x+2<board1.length && y-1>-1){
						if(board1[y-1][x+2]=='k'){
							return 'N';
						}
					}
					if(x+2<board1.length && y+1<board1.length){
						if(board1[y+1][x+2]=='k'){
							return 'N';
						}
					}
					//check left
					if(x-2>-1 && y-1>-1){
						if(board1[y-1][x-2]=='k'){
							return 'N';
						}
					}
					if(x-2>-1 && y+1<board1.length){
						if(board1[y+1][x-2]=='k'){
							return 'N';
						}
					}
				}
			}
		}
		return '-';
	}
	
	public static char getQueen(char[][] board1){
		for(int i=0; i<board1.length; i++){
			for(int g=0; g<board1[0].length; g++){
				//check if black Queen
				if(board1[i][g]=='q'){
					
					//checks all spaces below
					for(int y=i+1; y<board1.length; y++){
						
						if(board1[y][g]=='K'){
							return 'q';
						}
						if(board1[y][g] != '.'){
							break;
						}
					}
					
					//checks all spaces above
					for(int y=i-1; y>-1; y--){
						if(board1[y][g]=='K'){
							return 'q';
						}
						if(board1[y][g] != '.'){
							break;
						}
					}
					
					//check all space to the right
					for(int x=g+1; x>board1.length; x++){
						if(board1[i][x]=='K'){
							return 'q';
						}
						if(board1[i][x] != '.'){
							break;
						}
					}
					//check all spaces to the left
					for(int x=g-1; x>-1; x--){
						if(board1[i][x]=='K'){
							return 'q';
						}
						if(board1[i][x] != '.'){
							break;
						}
					}
					//checks bot right					
					int x = g+1;
					int y = i+1;
					while(x<board1[0].length && y<board1.length){
						if(board1[y][x]=='K'){
							return 'q';
						}
						if(board1[y][x] != '.'){
							break;
						}
						x++;
						y++;
					}
					//checks bot left					
					x = g-1;
					y = i+1;
					while(x>-1 && y<board1.length){
						if(board1[y][x]=='K'){
							return 'q';
						}
						if(board1[y][x] != '.'){
							break;
						}
						x--;
						y++;
					}
					
					//check top left
					x = g-1;
					y = i-1;
					while(x>-1 && y>-1){
						if(board1[y][x]=='K'){
							return 'q';
						}
						if(board1[y][x] != '.'){
							break;
						}
						x--;
						y--;
					}
					//check top right
					x = g+1;
					y = i-1;
					while(x<board1[0].length && y>-1){
						if(board1[y][x]=='K'){
							return 'q';
						}
						if(board1[y][x] != '.'){
							break;
						}
						x++;
						y--;
					}		
					
				}
				
				//check if white Queen
				if(board1[i][g]=='Q'){
					//checks all spaces below
					for(int y=i+1; y<board1.length; y++){
						
						if(board1[y][g]=='k'){
							return 'Q';
						}
						if(board1[y][g] != '.'){
							break;
						}
					}
					
					//checks all spaces above
					for(int y=i-1; y>-1; y--){
						if(board1[y][g]=='k'){
							return 'Q';
						}
						if(board1[y][g] != '.'){
							break;
						}
					}
					
					//check all space to the right
					for(int x=g+1; x>board1.length; x++){
						if(board1[i][x]=='k'){
							return 'Q';
						}
						if(board1[i][x] != '.'){
							break;
						}
					}
					//check all spaces to the left
					for(int x=g-1; x>-1; x--){
						if(board1[i][x]=='k'){
							return 'Q';
						}
						if(board1[i][x] != '.'){
							break;
						}
					}
					//checks bot right					
					int x = g+1;
					int y = i+1;
					while(x<board1[0].length && y<board1.length){
						if(board1[y][x]=='k'){
							return 'Q';
						}
						if(board1[y][x] != '.'){
							break;
						}
						x++;
						y++;
					}
					//checks bot left					
					x = g-1;
					y = i+1;
					while(x>-1 && y<board1.length){
						if(board1[y][x]=='k'){
							return 'Q';
						}
						if(board1[y][x] != '.'){
							break;
						}
						x--;
						y++;
					}
					
					//check top left
					x = g-1;
					y = i-1;
					while(x>-1 && y>-1){
						if(board1[y][x]=='k'){
							return 'Q';
						}
						if(board1[y][x] != '.'){
							break;
						}
						x--;
						y--;
					}
					//check top right
					x = g+1;
					y = i-1;
					while(x<board1[0].length && y>-1){
						if(board1[y][x]=='k'){
							return 'Q';
						}
						if(board1[y][x] != '.'){
							break;
						}
						x++;
						y--;
					}
					
					
				}
			}
		}
		return '-';
	}
	
	public static char getRook(char[][] board1){
		for(int i=0; i<board1.length; i++){
			for(int g=0; g<board1[0].length; g++){
				//check if black Rook
				if(board1[i][g]=='r'){
					
					//checks all spaces below
					for(int y=i+1; y<board1.length; y++){
						
						if(board1[y][g]=='K'){
							return 'r';
						}
						if(board1[y][g] != '.'){
							break;
						}
					}
					
					//checks all spaces above
					for(int y=i-1; y>-1; y--){
						if(board1[y][g]=='K'){
							return 'r';
						}
						if(board1[y][g] != '.'){
							break;
						}
					}
					
					//check all space to the right
					for(int x=g+1; x>board1.length; x++){
						if(board1[i][x]=='K'){
							return 'r';
						}
						if(board1[i][x] != '.'){
							break;
						}
					}
					//check all spaces to the left
					for(int x=g-1; x>-1; x--){
						if(board1[i][x]=='K'){
							return 'r';
						}
						if(board1[i][x] != '.'){
							break;
						}
					}
				}
				//check for white rook
				if(board1[i][g]=='R'){
					
					//checks all spaces below
					for(int y=i+1; y<board1.length; y++){
						
						if(board1[y][g]=='k'){
							return 'R';
						}
						if(board1[y][g] != '.'){
							break;
						}
					}
					
					//checks all spaces above
					for(int y=i-1; y>-1; y--){
						if(board1[y][g]=='k'){
							return 'R';
						}
						if(board1[y][g] != '.'){
							break;
						}
					}
					
					//check all space to the right
					for(int x=g+1; x>board1.length; x++){
						if(board1[i][x]=='k'){
							return 'R';
						}
						if(board1[i][x] != '.'){
							break;
						}
					}
					//check all spaces to the left
					for(int x=g-1; x>-1; x--){
						if(board1[i][x]=='k'){
							return 'R';
						}
						if(board1[i][x] != '.'){
							break;
						}
					}
				}
			}
		}
		//after checking entire board and no rooks checking
		return '-';
		
	}
	

	public static char getBishop(char[][] board1){
		for(int i=0; i<board1.length; i++){
			for(int g=0; g<board1[0].length; g++){
				//check if black Bishop
				if(board1[i][g]=='b'){
					
					//checks bot right					
					int x = g+1;
					int y = i+1;
					while(x<board1[0].length && y<board1.length){
						if(board1[y][x]=='K'){
							return 'b';
						}
						if(board1[y][x] != '.'){
							break;
						}
						x++;
						y++;
					}
					//checks bot left					
					x = g-1;
					y = i+1;
					while(x>-1 && y<board1.length){
						if(board1[y][x]=='K'){
							return 'b';
						}
						if(board1[y][x] != '.'){
							break;
						}
						x--;
						y++;
					}
					
					//check top left
					x = g-1;
					y = i-1;
					while(x>-1 && y>-1){
						if(board1[y][x]=='K'){
							return 'b';
						}
						if(board1[y][x] != '.'){
							break;
						}
						x--;
						y--;
					}
					//check top right
					x = g+1;
					y = i-1;
					while(x<board1[0].length && y>-1){
						if(board1[y][x]=='K'){
							return 'b';
						}
						if(board1[y][x] != '.'){
							break;
						}
						x++;
						y--;
					}
				}
				if(board1[i][g]=='B'){
					
					//checks bot right					
					int x = g+1;
					int y = i+1;
					while(x<board1[0].length && y<board1.length){
						if(board1[y][x]=='k'){
							return 'B';
						}
						if(board1[y][x] != '.'){
							break;
						}
						x++;
						y++;
					}
					//checks bot left					
					x = g-1;
					y = i+1;
					while(x>-1 && y<board1.length){
						if(board1[y][x]=='k'){
							return 'B';
						}
						if(board1[y][x] != '.'){
							break;
						}
						x--;
						y++;
					}
					
					//check top left
					x = g-1;
					y = i-1;
					while(x>-1 && y>-1){
						if(board1[y][x]=='k'){
							return 'B';
						}
						if(board1[y][x] != '.'){
							break;
						}
						x--;
						y--;
					}
					//check top right
					x = g+1;
					y = i-1;
					while(x<board1[0].length && y>-1){
						if(board1[y][x]=='k'){
							return 'B';
						}
						if(board1[y][x] != '.'){
							break;
						}
						x++;
						y--;
					}
				}
			}
		}
		return '-';
	}
		
	
	//take in chess board from test cases
	public static char getCheck(char[][] board){
		char check;		
		//iterate through the pawns
		check= getPawn(board);		
			//if '-' not returned, return method output
		if(check != '-'){
			return check;
		}
		
		//iterate through knights
		check= getKnight(board);			
		if(check != '-'){
			return check;
		}
		//iterate through bishops
		check = getBishop(board);
		if(check != '-'){
			return check;
		}
		
		//iterate through rooks
		check = getRook(board);
		if(check != '-'){
			return check;
		}		
		
		//iterate through queens
		check = getQueen(board);
		if(check != '-'){
			return check;
		}
		else{
			return '-';
		}
		//No need to iterate through king. without knowing whose turn it can't be known which king was checking which.
	}
	
}
