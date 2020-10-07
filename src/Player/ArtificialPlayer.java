package Player;

import java.util.Scanner;

public class ArtificialPlayer implements Player {
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

    public ArtificialPlayer(char sign) {
        name = "Artificial player";
        this.sign = sign;
    }

    @Override
    public String makeMove() {
        int move = (int) (Math.random() * 8);
        move++;
        return "" + move;
    }
}
