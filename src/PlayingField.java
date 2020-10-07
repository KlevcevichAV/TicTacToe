public class PlayingField {
    private char[] playingField;

    public PlayingField() {
        playingField = new char[9];
        for (int i = 0; i < 9; i++) {
            playingField[i] = (char) (i + 1 + '0');
        }
    }

    public int checkFreedom(String move){
        if(move.length() != 1) return -1;
        if(move.charAt(0) < '0' || move.charAt(0) > '9') return -1;
        int index = Integer.parseInt(move);
        if(playingField[index - 1] == index + '0'){
            return 0;
        }else {
            return 1;
        }
    }

    public void setValue(int index, char value) {
        playingField[index - 1] = value;
    }

    public void showPlayingField() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(playingField[count++] + " ");
            }
            System.out.println();
        }
    }

    public char checkWin() {
        for (int i = 0; i < 9; i += 3) {
            if (playingField[i] == playingField[i + 1] && playingField[i] == playingField[i + 2]) return playingField[i];
        }
        for (int i = 0; i < 3; i++) {
            if (playingField[i] == playingField[i + 3] && playingField[i] == playingField[i + 6]) return playingField[i];
        }
        if(playingField[0] == playingField[4] && playingField[4] == playingField[8]) return playingField[0];
        if(playingField[2] == playingField[4] && playingField[4] == playingField[6]) return playingField[2];
        return '-';
    }
}
