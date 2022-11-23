import java.util.Random;    //for random numbers
import java.util.Scanner;   //for user input

public class TicTacToe {
      
    public static void main(String[] args) {
        //creating a 2D char array for the board   
        char [][] gameBoard = {{'_','|','_','|','_'}, {'_','|','_','|','_'} , {' ','|',' ','|',' '}}; 
        showGameBoard(gameBoard);
        System.out.println("---------------");
        boolean gameOver = false;

        while(!gameOver) {
           moveOfThePlayer(gameBoard);
            gameOver = isTheGameOver(gameBoard);
            if(gameOver) {
                break;
            } 

            moveOfTheComputer(gameBoard);
            if(gameOver) {
                break;
            }
        }
    }

    //method that will print out the gameBoard, passing the array as a parameter
    public static void showGameBoard(char [][] gameBoard) {  
        //line 36 is equivalent to
        //1st loop - 3 rows
        //2nd loop - 5 columns

        for(int i = 0; i < gameBoard.length; i++) {
            for(int j = 0; j< 5; j++)
            {
                System.out.print(gameBoard[i][j]);
            }
            System.out.println();
        }    
    } 

    //now we'll make a method that will make the user enter X or O in the board
    // position (1-9), player (1 or 2), the gameBoard itself
    public static void updateBoard(int position, int player, char[][] gameBoard) {
        char character; //this will hold the symbol

        //if player 1 chose X then player 2 will alternatively choose 0
        if(player == 1) {
            character = 'X';
        } else {
            character = 'O';
        }

        if(position == 1) {
            gameBoard[0][0] = character;
            position++;
            showGameBoard(gameBoard);
        } else if(position == 2) {
            gameBoard[0][2] = character;
            showGameBoard(gameBoard);
        } else if(position == 3) {
            gameBoard[0][4] = character;
            showGameBoard(gameBoard);
        } else if(position == 4) {
            gameBoard[1][0] = character;
            showGameBoard(gameBoard);
        } else if(position == 5) {
            gameBoard[1][2] = character;
            showGameBoard(gameBoard);
        } else if(position == 6) {
            gameBoard[1][4] = character;
            showGameBoard(gameBoard);
        } else if(position == 7) {
            gameBoard[2][0] = character;
            showGameBoard(gameBoard);
        } else if(position == 8) {
            gameBoard[2][2] = character;
            showGameBoard(gameBoard);
        } else {
            gameBoard[2][4] = character;
            showGameBoard(gameBoard);
        }
    }

    public static boolean isFilled(int move, char[][] gameBoard) {
        //this method checks whether the space is filled or not
        //if its not a dash or a space then that location is filled, so it is an invalid move
        switch(move) {
            case 1:
                if(gameBoard[0][0] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 2:
                if(gameBoard[0][2] == '_') {
                    return true;
                } else {
                    return false;
                } 
            case 3:
                if(gameBoard[0][4] == '_') {
                    return true;
                } else {
                    return false;
                } 
            case 4:
                if(gameBoard[1][4] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 5:
                if(gameBoard[1][4] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 6:
                if(gameBoard[1][4] == '_') {
                    return true;
                } else {
                    return false;
                }  
            case 7:
                if(gameBoard[2][4] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 8:
                if(gameBoard[2][4] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 9:
                if(gameBoard[2][4] == ' ') {
                    return true;
                } else {
                    return false;
                }
            default: 
            return false;
        }
    }


    public static void moveOfThePlayer(char[][] gameBoard) {
        System.out.println("Please make a move. (1-9)");
        Scanner input = new Scanner(System.in);
        int move = input.nextInt();
        
        boolean isValid = isFilled(move, gameBoard);

        //while it is not valid, send an error message and promt the user again to enter a valid move
        while(!isValid) {
            System.out.println("Move has already been entered, enter a another move.");
             
            move = input.nextInt();
            isValid = isFilled(move, gameBoard);
        }
        int player = 1;
        updateBoard(move, player, gameBoard);
    }
    public static void moveOfTheComputer(char[][] gameBoard) {

        Random rand = new Random();
        int move = rand.nextInt(9) + 1;

        boolean isValid = isFilled(move, gameBoard);
        while(!isValid) { 
            move = rand.nextInt(9) + 1;
            isValid = isFilled(move, gameBoard);
        }
        int player = 2;
        updateBoard(move, player, gameBoard);
    }

    //cases where the game is over or not
    public static boolean isTheGameOver(char[][] gameBoard) {
        //Horizontal win for player & computer
        if(gameBoard[0][0] == 'X' && gameBoard[0][2] == 'X' && gameBoard[0][4] == 'X') {
            System.out.println("Player Wins The Game!");
            return true;
        }

        if(gameBoard[0][0] == 'O' && gameBoard[0][2] == 'O' && gameBoard[0][4] == 'O') {
            System.out.println("Computer Wins The Game!");
            return true;
        }

        if(gameBoard[1][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[1][4] == 'X') {
            System.out.println("Player Wins The Game!");
            return true;
        }

        if(gameBoard[1][0] == 'O' && gameBoard[1][2] == 'O' && gameBoard[1] [4] == 'O') {
            System.out.println("Computer Wins The Game!");
            return true;
        }

        if(gameBoard[2][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[2][4] == 'X') {
            System.out.println("Player Wins The Game!");
            return true;
        }

        if(gameBoard[2][0] == 'O' && gameBoard[2][2] == 'O' && gameBoard[2] [4] == 'O') {
            System.out.println("Computer Wins The Game!");
            return true;
        }

        //Vertical win for player & computer
        if(gameBoard[0][0] == 'X' && gameBoard[1][0] == 'X' && gameBoard[2][0] == 'X') {
            System.out.println("Player Wins The Game!");
            return true;
        }

        if(gameBoard[0][0] == 'O' && gameBoard[1][0] == 'O' && gameBoard[2][0] == 'O') {
            System.out.println("Computer Wins The Game!");
            return true;
        }

        if(gameBoard[0][2] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][2] == 'X') {
            System.out.println("Player Wins The Game!");
            return true;
        }

        if(gameBoard[0][2] == 'O' && gameBoard[1][2] == 'O' && gameBoard[2][2] == 'O') {
            System.out.println("Computer Wins The Game!");
            return true;
        }

        if(gameBoard[0][4] == 'X' && gameBoard[1][4] == 'X' && gameBoard[2][4] == 'X') {
            System.out.println("Player Wins The Game!");
            return true;
        }

        if(gameBoard[0][4] == 'O' && gameBoard[1][4] == 'O' && gameBoard[2][4] == 'O') {
            System.out.println("Computer Wins The Game!");
            return true;
        }

        //Diagonal win
        if(gameBoard[0][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][4] == 'X') {
            System.out.println("Player Wins The Game!");
            return true;
        }

        if(gameBoard[0][0] == 'O' && gameBoard[1][2] == 'O' && gameBoard[2][4] == 'O') {
            System.out.println("Computer Wins The Game!");
            return true;
        }

        if(gameBoard[0][4] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][0] == 'X') {
            System.out.println("Player Wins The Game!");
            return true;
        }

        if(gameBoard[0][4] == 'O' && gameBoard[1][2] == 'O' && gameBoard[2][0] == 'O') {
            System.out.println("Computer Wins The Game!");
            return true;
        }

        //for a tie
        if(gameBoard[0][0] != '_' && gameBoard[0][2] != '_' && gameBoard[0][4] != '_' 
        && gameBoard[1][0] != '_' && gameBoard[1][2] != '_' && gameBoard[1][4] != '_'
        && gameBoard[2][0] != ' ' && gameBoard[2][2] != ' ' && gameBoard[2][4] != ' ') {
            System.out.println("It's a tie.");
            return true;
        }
        return false; 
    }
}
