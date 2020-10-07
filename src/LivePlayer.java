import java.util.Scanner;

public class LivePlayer implements Player {
    private String name;
    private char sign;

    @Override
    public String getName() {
        if (name.equals("")) {
            return null;
        } else {
            return name;
        }
    }

    @Override
    public char getSign() {
        return sign;
    }

    public LivePlayer(char sign) {
        name = "";
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
        System.out.println("Введите поле для хода.");
        move = in.nextLine();
        return move;
    }
}
