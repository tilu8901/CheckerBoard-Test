package tianhualu.project;

public class Main {
	//-------------- Variables to store signs and numbers ---------------//
	public static String NUMB_SIGN = "#";
	public static String NEWLINE = "\n";
	public static String DASH = "-";
	public static String PLUS = "+";
	public static String BAR = "|";
	public static String SPACE = " ";
	public static int DRAW_SIGN = 1;
	public static int DRAW_SPACE = 0;
	
	//-------------------------------------- Main Function ----------------------------------------------//
	public void draw_checker_board(int square_size,int board_size){
		check_errors(square_size,board_size);//First check for input errors
		String top = getTopLayer(square_size,board_size); //The top +---+
		String side = getSideLayer(board_size); //The side |
		int row[] = get_row(square_size,board_size); //An array that stores the values # = 1 and ' ' = 0
		String checkerboard = ""; //Variable to store the entire Checker Board
		int no_of_rows = square_size*board_size;
		//------- Composing Checker Board -------//
		for(int i = 0;i < no_of_rows;i ++){
			if(i%square_size == 0){;
			checkerboard += top+NEWLINE;
			} 
			if(i % square_size == 0 && i != 0){
				row = reverse_row(row,square_size,board_size);
			}
			for(int j = 0;j < no_of_rows;j ++){
				if(j % square_size == 0){
					checkerboard += side;
				}
				if(row[j] == 1){
					checkerboard += NUMB_SIGN;
				}
				else{
					checkerboard += SPACE;
				}
				if(j == no_of_rows - 1){
					checkerboard += BAR+NEWLINE;
				}
			}
		}
		//---------------------------------------//
		checkerboard += top;
		System.out.print(checkerboard); //Print the board
	}
	
	
	//-------------------------------- Helper Methods -----------------------------------//
	/*
	 * Creates the top layer +---+---+ based on square_size x board_size
	 */
	public String getTopLayer(int square_size,int board_size){ 
		String layer = "";
		for(int j = 0;j < board_size;j ++){
			for(int i=0;i<square_size;i++){
				if(i == 0){
					layer += "+";
				}
				layer += "-";
			}
		}
		return layer+"+";
	}
	/*
	 * Returns the side bar |
	 */
	public String getSideLayer(int square_size){
		return BAR;
	}
	/*
	 * Returns an array with numbers in each element DRAW_SIGN(1) represents # and DRAW_SPACE(0) represents ' '
	 */
	public int[] get_row(int square_size,int board_size){
		int matrix_size = square_size*board_size;
		int counter = 0;
		int value = DRAW_SIGN;
		int row[] = new int[matrix_size];
		for(int i = 0;i < matrix_size;i ++){
			if(counter == 0){
				value = DRAW_SIGN;
			}
			else if(counter == square_size){
				value = DRAW_SPACE;
			}
			if(value==DRAW_SIGN){
				counter ++;
			}
			else if(value == DRAW_SPACE){
				counter --;
			}
			row[i] = value;
		}
		return row;
	}
	/*
	 * Reversing an array eg from 111222111 to 222111222
	 */
	public int[] reverse_row(int[] row,int square_size,int board_size){
		int size = row.length;
		int new_row[] = new int[size];
		for(int i = 0;i < size;i ++){
			if(row[i] == DRAW_SIGN){
				new_row[i] = DRAW_SPACE;
			}
			else if(row[i] == DRAW_SPACE){
				new_row[i] = DRAW_SIGN;
			}
		}
		return new_row;
	}
	/*
	 * Check for input errors
	 */
	public void check_errors(int square_size,int board_size){
		if(square_size == 0 || board_size == 0){
			System.out.println("<Error> square_size and board_size cannot be 0.");
			System.exit(0);
		}
		if(square_size < 0 || board_size < 0){
			System.out.println("<Error> square_size and board_size cannot be negative.");
			System.exit(0);
		}
	}
	
	
	//===================**RUN HERE**====================//
	public static void main(String args[]){
		Main a = new Main();
		a.draw_checker_board(10,5);
	}
}
