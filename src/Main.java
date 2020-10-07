import Player.Player;

import java.util.Scanner;

import Player.LivePlayer;
import Player.ArtificialPlayer;

public class Main {

    public static boolean inputChoice(String message) {
        Scanner in = new Scanner(System.in);
        String choice;
        do {
            System.out.println(message);
            System.out.print("Your choice: ");
            choice = in.nextLine();
        } while (!choice.equals("1") && !choice.equals("2"));
        if (choice.equals("1")) {
            return true;
        } else {
            return false;
        }
    }

    public static Player createPlayers(boolean checkLivePlayer, boolean checkName, char sign) {
        Player player;
        if (!checkLivePlayer) {
            player = new ArtificialPlayer(sign);
//            return player;
        } else {
            if (checkName) {
                System.out.print("Input your name: ");
                Scanner in = new Scanner(System.in);
                String name = in.nextLine();
                player = new LivePlayer(sign, name);
            } else {
                player = new LivePlayer(sign, (sign == 'X') ? 1 : 2);
            }
        }
        return player;
    }

    public static String makeMove(PlayingField playingField, Player player) {
        String move;
        do {
            move = player.makeMove();
        } while (playingField.checkFreedom(move) != 0);
        System.out.println("Move:" + move);
        return move;
    }

    public static void start(PlayingField playingField, Player firstPlayer, Player secondPlayer) {
        for (int i = 0; i < 9; i++) {
            playingField.showPlayingField();
            String move;
            if (i % 2 == 0) {
                if (firstPlayer.getSign() == 'X') {
                    move = makeMove(playingField, firstPlayer);
                    playingField.setValue(Integer.parseInt(move), firstPlayer.getSign());
                } else {
                    move = makeMove(playingField, secondPlayer);
                    playingField.setValue(Integer.parseInt(move), secondPlayer.getSign());
                }
            } else {
                if (firstPlayer.getSign() == 'O') {
                    move = makeMove(playingField, firstPlayer);
                    playingField.setValue(Integer.parseInt(move), firstPlayer.getSign());
                } else {
                    move = makeMove(playingField, secondPlayer);
                    playingField.setValue(Integer.parseInt(move), secondPlayer.getSign());
                }
            }
            char checkWin = playingField.checkWin();
            if (checkWin != '-') {
                playingField.showPlayingField();
                String nameWinner = (checkWin == firstPlayer.getSign()) ? firstPlayer.getName() : secondPlayer.getName();
                System.out.println("Congratulations!" + nameWinner + " with a victory!");
                return;
            }

        }
        System.out.println("Ooh ... it's a draw");
    }

    public static void game() {
        PlayingField playingField = new PlayingField();
        Player firstPlayer = null;
        Player secondPlayer = null;
        boolean choiceCounterPlayers = inputChoice("Игра с компьютером или с другим человеком?\n1. С другим человеком;\n2. С компьютером.");
        boolean choiceSaveNamesPlayers = inputChoice("Желаете ввести имя?\n1. Да;\n2. Нет.");
        firstPlayer = createPlayers(true, choiceSaveNamesPlayers, 'X');
        secondPlayer = createPlayers(choiceCounterPlayers, choiceSaveNamesPlayers, 'O');
        start(playingField, firstPlayer, secondPlayer);
    }

    public static void main(String[] args) {
        game();
    }
}
