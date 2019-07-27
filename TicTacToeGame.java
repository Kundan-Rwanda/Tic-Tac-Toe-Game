/*
Author: Kundan Kumar
About Author: Founder & CEO of Let's Code Bootcamp
Web: https://www.letscodebootcamp.com
Email: info@letscodebootcamp.com  or kundan.kumar011@gmail.com
Created on: 26/07/2019
 */
public class TicTacToeGame {
    static int gameboard[][]=new int[3][3];
    static final int EMPTY = 0;
    static final int NOUGHT = -1;
    static final int CROSS = 1;
    static final int TIE=2;
    static int TotalturnCounter; // Total Turn including both team is 9

    static  int turn=0; //To keep track the player turn

    static void set(int val, int row, int col)throws IllegalArgumentException
    {
        if (gameboard[row][col] == EMPTY) {
            gameboard[row][col] = val;
            turn++;  //Advance by to change the turn
            TotalturnCounter++;  // Keep advancing how many turns over , it can not exceed more then 9
        }
        else throw new IllegalArgumentException("Player already there!");
    }
    //Displaying Board
    static void displayBoard()
    {
        for( int r = 0; r < gameboard.length; r++ ) {
            // System.out.print("|");
            for (int c = 0; c < gameboard[r].length; c++) {
                switch (gameboard[r][c]) {
                    case NOUGHT:
                        System.out.print("O");
                        break;
                    case CROSS:
                        System.out.print("X");
                        break;
                    default: //Empty
                        System.out.print(" ");
                }
                if (c < 2) {
                    System.out.print(" | ");
                }
            }

            if(r<2)
            System.out.println("\n----------");
        }
        System.out.println();
    }
    //Creating Bord
    static void createBoard(int rows,int cols)
    {
        int r,c;
        for(r=0;r<rows;r++)
        {
            for(c=0;c<cols;c++)
            {
                //Initialize the game board with Empty =0
                gameboard[r][c]=EMPTY;
            }
        }
    }
    //To check winner
    static int winOrTie()
    {
        //Determine whether CROSS (X) or NOUGHT (O) won or there is a tie
        /*************** Starts NOUGHT Checking to win***********************/
        // Checking Rows wise to win NOUGHT
        if(gameboard[0][0] == NOUGHT && gameboard[0][1] == NOUGHT && gameboard[0][2] == NOUGHT)
            return NOUGHT;
        if(gameboard[1][0] == NOUGHT && gameboard[1][1] == NOUGHT && gameboard[1][2] == NOUGHT)
            return NOUGHT;
        if(gameboard[2][0] == NOUGHT && gameboard[2][1] == NOUGHT && gameboard[2][2] == NOUGHT)
            return NOUGHT;

        // Checking Colums wise to win NOUGHT
        if(gameboard[0][0] == NOUGHT && gameboard[1][0] == NOUGHT && gameboard[2][0] == NOUGHT)
            return NOUGHT;
        if(gameboard[0][1] == NOUGHT && gameboard[1][1] == NOUGHT && gameboard[2][1] == NOUGHT)
            return NOUGHT;
        if(gameboard[0][2] == NOUGHT && gameboard[1][2] == NOUGHT && gameboard[2][2] == NOUGHT)
            return NOUGHT;

        // Checking diagonal wise to win NOUGHT
        if(gameboard[0][0] == NOUGHT && gameboard[1][1] == NOUGHT && gameboard[2][2] == NOUGHT)
            return NOUGHT;
        if(gameboard[0][2] == NOUGHT && gameboard[1][1] == NOUGHT && gameboard[2][0] == NOUGHT)
            return NOUGHT;
        /*************** Ends NOUGHT Checking to win***********************/


        /*************** Starts CROSS Checking to win***********************/
        // Checking Rows wise to win CROSS
        if(gameboard[0][0] == CROSS && gameboard[0][1] == CROSS && gameboard[0][2] == CROSS)
            return CROSS;
        if(gameboard[1][0] == CROSS && gameboard[1][1] == CROSS && gameboard[1][2] == CROSS)
            return CROSS;
        if(gameboard[2][0] == CROSS && gameboard[2][1] == CROSS && gameboard[2][2] == CROSS)
            return CROSS;

        // Checking Colums wise to win CROSS
        if(gameboard[0][0] == CROSS && gameboard[1][0] == CROSS && gameboard[2][0] == CROSS)
            return CROSS;
        if(gameboard[0][1] == CROSS && gameboard[1][1] == CROSS && gameboard[2][1] == CROSS)
            return CROSS;
        if(gameboard[0][2] == CROSS && gameboard[1][2] == CROSS && gameboard[2][2] == CROSS)
            return CROSS;

        // Checking diagonal wise to win CROSS
        if(gameboard[0][0] == CROSS && gameboard[1][1] == CROSS && gameboard[2][2] == CROSS)
            return CROSS;
        if(gameboard[0][2] == CROSS && gameboard[1][1] == CROSS && gameboard[2][0] == CROSS)
            return CROSS;
        /*************** Ends CROSS Checking to win***********************/
        if(TotalturnCounter==9)
            return TIE;
        return -2;
    }
    public static void main(String[] args)throws Exception
    {
        // To create 3 * 3 TicTacToe Game Board
        createBoard(3,3);

        int playerVal;
        int outcome;

        int rowNum,colNum;

        java.util.Scanner scan = new java.util.Scanner(System.in);
        do
        {
            displayBoard(); // Calling displayBoard() method

            //To check whose turn
            playerVal = (turn % 2 == 0)? NOUGHT : CROSS;

            if (playerVal == NOUGHT)
                System.out.println("\n—O’s turn—" );
            else
                System.out.println("\n—X’s turn—" );

            System.out.print("Enter row and column:" );
            try
            {
                rowNum=scan.nextInt();
                colNum=scan.nextInt();
                set(playerVal, rowNum, colNum);
            }
            catch (IllegalArgumentException ex)
            {
                System.err.println(ex.getIllegalArgumentExceptionMessage());
            }
            outcome = winOrTie(); //
        } while ( outcome == -2 );
        displayBoard();

        //Checking who is winner
        switch (outcome)
        {
            case NOUGHT:
                System.out.println("\nO wins!" );
                break;
            case CROSS:
                System.out.println("\nX wins!");
                break;
            case TIE:
                System.out.println("\nTie.");
                break;
        }
    }
}
// IllegalArgementException Class to handle the Set Method
class IllegalArgumentException extends Exception
{
    private String exceptionmsg;
    public IllegalArgumentException(String errmsg)
    {
        exceptionmsg=errmsg;
    }
    public String getIllegalArgumentExceptionMessage()
    {
        return exceptionmsg;
    }
}
