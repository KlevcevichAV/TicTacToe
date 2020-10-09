package Player;

import Player.Player;

import java.util.Scanner;

public class LivePlayer implements Player {
    private String name;
    private char sign;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public char getSign() {
        return sign;
    }

    public LivePlayer(char sign, int index) {
        name = "Player " + index;
        this.sign = sign;
    }

    public LivePlayer(char sign, String name) {
        this.sign = sign;
        this.name = name;
    }

    @Override
    public String makeMove() {
        Scanner in = new Scanner(System.in);
        String move = "";
        System.out.print("Enter the field for the move: ");
        move = in.nextLine();
        return move;
    }
}
