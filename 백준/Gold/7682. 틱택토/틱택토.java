import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    private static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;

        return false;
    }

    private static String validate(String input) {
        if (input.equals("end")) return null;

        char[][] board = new char[3][3];
        int countX = 0;
        int countO = 0;

        for (int i = 0; i < 9; i++) {
            char c = input.charAt(i);
            board[i / 3][i % 3] = c;
            if (c == 'X') {
                countX++;
            } else if (c == 'O') {
                countO++;
            }
        }

        if (countX < countO || countX > countO + 1) {
            return "invalid";
        }

        boolean winX = checkWin(board, 'X');
        boolean winO = checkWin(board, 'O');

        if (winX && !winO) {
            return (countX == countO + 1) ? "valid" : "invalid";
        }

        if (!winX && winO) {
            return (countX == countO) ? "valid" : "invalid";
        }

        if (!winX && !winO) {
            if (countX + countO == 9) {
                return (countX == countO + 1) ? "valid" : "invalid";
            } else {
                return "invalid";
            }
        }

        return "invalid";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder sb = new StringBuilder();

        while ((input = br.readLine()) != null) {
            if (input.equals("end")) {
                break;
            }
            sb.append(validate(input)).append("\n");
        }
        System.out.print(sb.toString());
    }
}