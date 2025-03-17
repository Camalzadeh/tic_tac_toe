import java.util.Scanner;

public class Main {
    static public class Player{
        char element;
        public Player(char element){
            this.element = element;
        }
        public void move(int row, int col){

        }
    }
    
    static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
    static void makeMove(int row, int col, char player){
        board[row][col] = player;
    }
    static void getMove(Scanner scanner, char element){
        while(true){
            int row,col;
            System.out.println("Enter row and column number (x y) for PLayer "+element+" : ");
            if(scanner.hasNextInt()){
                row=scanner.nextInt()-1;
                if(row<0 || row>=3){
                    System.out.println("Invalid row number, please try again\n");
                }
                else if(scanner.hasNextInt()){
                    col=scanner.nextInt()-1;
                    if(col<0 || col>=3){
                        System.out.println("Invalid column number, please try again\n");
                    }
                    else if(!isValidMove(row,col)){
                        System.out.println("Invalid move, please try again\n");
                    }
                    else{
                        makeMove(row,col,element);
                        break;
                    }
                }
                else{
                    System.out.println("Invalid input for column , please try again\n");
                    scanner.next();
                }
            }
            else{
                System.out.println("Invalid input for row, please try again\n");
                scanner.next();
            }
        }
    }
    static boolean isValidMove(int row, int col){
        return board[row][col] == ' ';
    }
    static boolean checkForWin(char element){
        for (int i = 0; i < 3; i++) {
            if(board[i][0] == element && board[i][1] == element && board[i][2] == element){
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if(board[0][i] == element && board[1][i] == element && board[2][i] == element){
                return true;
            }
        }
        if(board[0][0] == element && board[1][1] == element && board[2][2] == element){
            return true;
        }
        if(board[0][2] == element && board[1][1] == element && board[2][0] == element){
            return true;
        }
        return false;
    }
    static boolean isDraw(){
        boolean draw = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j] == ' '){
                    draw=false;
                    break;
                }
            }
        }
        return draw;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printBoard();
        while(true){
            getMove(scanner, 'X');
            printBoard();
            if(checkForWin('X')){
                System.out.println("Player X wins!");
                break;
            }
            if(isDraw()){
                System.out.println("Game ends with Draw!");
                break;
            }
            getMove(scanner, 'O');
            printBoard();
            if(checkForWin('O')){
                System.out.println("Player O wins!");
                break;
            }
            if(isDraw()){
                System.out.println("Game ends with Draw!");
                break;
            }
        }
        scanner.close();
    }
}