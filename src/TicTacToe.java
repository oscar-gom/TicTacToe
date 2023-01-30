import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        int usersChoice;
        boolean correctType;
        boolean turn = false; //false = user1, true = user2
        int moves = 0;
        char[][] gameBoard = new char[3][3];
        char[] check = new char[3];
        do {
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
                correctType = false;
                if (!turn) {
                    System.out.println("Player 1:");
                } else {
                    System.out.println("Player 2:");
                }
                usersChoice = readInt("caca", 1, 9);
                switch (usersChoice) {
                    case 1, 2, 3 -> {
                        if (gameBoard[0][usersChoice - 1] != ' ') { //Check if space already occupied
                            System.out.println("THE SPACE IS ALREADY OCUPPIED");
                        } else {
                            if (!turn) {
                                gameBoard[0][usersChoice - 1] = 'X';
                                turn = true;
                            } else {
                                gameBoard[0][usersChoice - 1] = 'O';
                                turn = false;
                            }
                            moves++;
                        }
                    }
                    case 4, 5, 6 -> {
                        if (gameBoard[1][usersChoice - 4] != ' ') {
                            System.out.println("THE SPACE IS ALREADY OCUPPIED");
                        } else {
                            if (!turn) {
                                gameBoard[1][usersChoice - 4] = 'X';
                                turn = true;
                            } else {
                                gameBoard[1][usersChoice - 4] = 'O';
                                turn = false;
                            }
                            moves++;
                        }
                    }
                    case 7, 8, 9 -> {
                        if (gameBoard[2][usersChoice - 7] != ' ') {
                            System.out.println("THE SPACE IS ALREADY OCUPPIED");
                        } else {
                            if (!turn) {
                                gameBoard[2][usersChoice - 7] = 'X';
                                turn = true;
                            } else {
                                gameBoard[2][usersChoice - 7] = 'O';
                                turn = false;
                            }
                            moves++;
                        }
                    }
                    case default -> System.out.println("ERROR: TYPE A NUMBER FROM 1-9");
                }
                //Checking winning, losing or draw
                //Rows
                if (gameBoard[0][0] == 'X' && gameBoard[0][1] == 'X' && gameBoard[0][2] == 'X' ||
                        gameBoard[1][0] == 'X' && gameBoard[1][1] == 'X' && gameBoard[1][2] == 'X' ||
                        gameBoard[2][0] == 'X' && gameBoard[2][1] == 'X' && gameBoard[2][2] == 'X' ||
                        //Diagonals
                        gameBoard[0][0] == 'X' && gameBoard[1][1] == 'X' && gameBoard[2][2] == 'X' ||
                        gameBoard[0][2] == 'X' && gameBoard[1][1] == 'X' && gameBoard[2][0] == 'X') {
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
                } else if (moves == 9) {
                    System.out.println("It was a DRAW!");
                    correctType = true;
                }
            } while (!correctType);
        } while (moves != 9);
    }

    /**
     * This method asks the user for an integer and checks if it's correct
     * @param message Show a message to ask the user for an int
     * @param min Minimum value accepted
     * @param max Maximum value accepted
     * @return Returns a correct integer
     */
    private static int readInt(String message, int min, int max) {
        boolean correctType = false;
        int x = 0;
        Scanner llegir = new Scanner(System.in);

        do {
            System.out.println(message);
            correctType = llegir.hasNextInt();
            if (!correctType) {
                System.out.println("ERROR: Value not Integer");
                llegir.nextLine();
            } else { // Tinc un enter
                x = llegir.nextInt();
                llegir.nextLine();
                if (x < min || x > max) {
                    System.out.println("ERROR: Not a valid option");
                    correctType = false;
                }
            }
        } while (!correctType);

        return x;
    }
}