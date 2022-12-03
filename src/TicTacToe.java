import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        int usersChoice;
        boolean correctType;
        boolean turn = false; //false = user1, true = user2
        int moves = 0;
        char[][] gameBoard = new char[3][3];
        char[] check = new char[3];
        Scanner scanner = new Scanner(System.in);

        do {
            for (int row = 0; row < gameBoard.length; row++) {
                for (int col = 0; col < gameBoard.length; col++) {
                    if (gameBoard[row][col] == 0) {
                        gameBoard[row][col] = ' ';
                    }
                    System.out.print("|" + gameBoard[row][col]);
                }
                System.out.println("|");
                System.out.println("-------");
            }
            //Game
            do {
                correctType = false;
                if (!turn){
                    System.out.println("Player 1:");
                }else {
                    System.out.println("Player 2:");
                }
                System.out.println("Choose a cell (1-9)");
                correctType = scanner.hasNextInt();
                if (!correctType) {
                    System.out.println("ERROR: Type a whole number");
                    scanner.nextLine();
                }else {
                    usersChoice = scanner.nextInt();
                        switch (usersChoice) {
                            case 1, 2, 3 -> {
                                if (gameBoard[0][usersChoice - 1] != ' ') { //Check if space already occupied
                                    System.out.println("THE SPACE IS ALREADY OCUPPIED");
                                    scanner.nextLine();
                                } else {
                                    if (!turn){
                                        gameBoard[0][usersChoice - 1] = 'X';
                                        moves++;
                                        turn = true;
                                    }else {
                                        gameBoard[0][usersChoice - 1] = 'O';
                                        moves++;
                                        turn = false;
                                    }
                                }
                            }
                            case 4, 5, 6 -> {
                                if (gameBoard[1][usersChoice - 4] != ' ') {
                                    System.out.println("THE SPACE IS ALREADY OCUPPIED");
                                    scanner.nextLine();
                                } else {
                                    if (!turn){
                                        gameBoard[1][usersChoice - 4] = 'X';
                                        moves++;
                                        turn = true;
                                    }else {
                                        gameBoard[1][usersChoice - 4] = 'O';
                                        moves++;
                                        turn = false;
                                    }
                                }
                            }
                            case 7, 8, 9 -> {
                                if (gameBoard[2][usersChoice - 7] != ' ') {
                                    System.out.println("THE SPACE IS ALREADY OCUPPIED");
                                    scanner.nextLine();
                                } else {
                                    if (!turn){
                                        gameBoard[2][usersChoice - 7] = 'X';
                                        moves++;
                                        turn = true;
                                    }
                                    else {
                                        gameBoard[2][usersChoice - 7] = 'O';
                                        moves++;
                                        turn = false;
                                    }
                                }
                            }
                            case default -> System.out.println("ERROR: TYPE A NUMBER FROM 1-9");
                    }
                }
                //Checking winning, losing or draw
                //Rows
                if (gameBoard[0][0] == 'X' && gameBoard[0][1] == 'X' && gameBoard[0][2] == 'X' ||
                        gameBoard[1][0] == 'X' && gameBoard[1][1] == 'X' && gameBoard[1][2] == 'X' ||
                        gameBoard[2][0] == 'X' && gameBoard[2][1] == 'X' && gameBoard[2][2] == 'X' ||
                        //Diagonals
                        gameBoard[0][0] == 'X' && gameBoard[1][1] == 'X' && gameBoard[2][2] == 'X' ||
                        gameBoard[0][2] == 'X' && gameBoard[1][1] == 'X' && gameBoard[2][0] == 'X'){
                    System.out.println("Player 1 WINS!");
                    correctType = true;
                    moves = 9;
                    //Rows
                } else if (gameBoard[0][0] == 'O' && gameBoard[0][1] == 'O' && gameBoard[0][2] == 'O' ||
                        gameBoard[1][0] == 'O' && gameBoard[1][1] == 'O' && gameBoard[1][2] == 'O' ||
                        gameBoard[2][0] == 'O' && gameBoard[2][1] == 'O' && gameBoard[2][2] == 'O' ||
                        //Diagonals
                        gameBoard[0][0] == 'O' && gameBoard[1][1] == 'O' && gameBoard[2][2] == 'O' ||
                        gameBoard[0][2] == 'O' && gameBoard[1][1] == 'O' && gameBoard[2][0] == 'O') {
                    System.out.println("Player 2 WINS!");
                    correctType = true;
                    moves = 9;
                }else if (moves == 9){
                    System.out.println("It was a DRAW!");
                    correctType = true;
                }
            } while (!correctType);
        } while (moves != 9);
    }
}