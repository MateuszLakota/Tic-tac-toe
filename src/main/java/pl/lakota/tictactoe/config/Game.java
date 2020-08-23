package pl.lakota.tictactoe.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class Game {
    @Getter
    @Setter
    private List<String> currentTTT;

    @Getter
    @Setter
    private List<String> previousTTT;

    public void updateGame() {
        if (this.isValid()) {
            this.overwritePreviousTTTWithCurrentTTT();
            this.drawACircleInCurrentTTT();
        } else {
            this.overwriteCurrentTTTWithPreviousTTT();
        }
    }

    private boolean isValid() {
        List<Integer> indeksyTamGdzieBedoRoznice = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (!currentTTT.get(i).equals(previousTTT.get(i))) {
                indeksyTamGdzieBedoRoznice.add(i);
            }
        }
        if (indeksyTamGdzieBedoRoznice.size() == 0) {
            return true;
        } else {
            int indexTamGdzieJestRoznica = indeksyTamGdzieBedoRoznice.get(0);
            String original = previousTTT.get(indexTamGdzieJestRoznica);
            String newValue = currentTTT.get(indexTamGdzieJestRoznica);
            return original.isEmpty() && newValue.equals("X");
        }
    }

    private void overwritePreviousTTTWithCurrentTTT() {
        for (byte i = 0; i < 9; i++) {
            this.previousTTT.set(i, this.currentTTT.get(i));
        }
    }

    private void drawACircleInCurrentTTT() {
        List<Integer> indeksyPolPustych = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (this.currentTTT.get(i).equals("")) {
                indeksyPolPustych.add(i);
            }
        }
        Random random = new Random();
        this.currentTTT.set(random.nextInt(indeksyPolPustych.size()), "O");
    }

    private void overwriteCurrentTTTWithPreviousTTT() {
        for (byte i = 0; i < 9; i++) {
            this.currentTTT.set(i, this.previousTTT.get(i));
        }
    }
}
