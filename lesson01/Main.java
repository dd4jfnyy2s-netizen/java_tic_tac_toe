    package lesson01;
    import java.util.Scanner;
    public class Main {
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            int turn = 0;

            char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
            };

            while(true) {

                System.out.println("行番号を入力してください（0〜2）");
                int row = scanner.nextInt();

                System.out.println("列番号を入力してください（0〜2）");
                int col = scanner.nextInt();

                if(row >= 0 && row < 3 && col >= 0 && col < 3) {

                    if(board[row][col] == ' ') {

                        if(turn == 0) {
                            board[row][col] = '×';
                        } else {
                            board[row][col] = '○';
                        }

                        turn = 1 - turn;

                    } else {
                        System.out.println("すでに指定されたマスに記号が存在しています");
                    }

                } else {
                    System.out.println("0〜2の数字を入力してください");
                }

            for(int i = 0; i < 3; i ++) {
                for(int j = 0; j < 3; j ++) {
                    System.out.print(board[i][j]); 
                    if(j < 2) {
                        System.out.print(" | ");
                    }            
                }
                System.out.println();
                if(i < 2) {
                    System.out.println("---------");
                }
            }

            if(//横が揃った条件式
                board[0][0] == board[0][1] &&
                board[0][1] == board[0][2] &&
                board[0][0] != ' '
                ||
                board[1][0] == board[1][1] &&
                board[1][1] == board[1][2] &&
                board[1][0] != ' '
                ||
                board[2][0] == board[2][1] &&
                board[2][1] == board[2][2] &&
                board[2][0] != ' ' 
                ||
                //縦が揃った条件式
                board[0][0] == board[1][0] &&
                board[1][0] == board[2][0] &&
                board[0][0] != ' '
                ||
                board[0][1] == board[1][1] &&
                board[1][1] == board[2][1] &&
                board[0][1] != ' '
                ||
                board[0][2] == board[1][2] &&
                board[1][2] == board[2][2] &&
                board[0][2] != ' '
                ||
                //斜めが揃った条件式
                board[0][0] == board[1][1] &&
                board[1][1] == board[2][2] &&
                board[0][0] != ' '
                ||
                board[0][2] == board[1][1] &&
                board[1][1] == board[2][0] &&
                board[0][2] != ' '
                ) {
                    if(turn == 1) {
                        System.out.println("×の勝利！");
                        break;
                    } else {
                        System.out.println("○の勝利！");
                        break;
                    }
                }
                //引き分け
                boolean isFull = true;

                for(int i = 0; i < 3; i ++) {
                    for(int j = 0; j < 3; j ++) {
                        if(board[i][j] == ' ') {
                                isFull = false;
                        }
                    }
                }
                if(isFull == true) {
                    System.out.println("引き分け！");
                    break;
                }
            }
        }
    }