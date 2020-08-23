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
    private List<String> currentBoard;

    @Getter
    @Setter
    private List<String> previousBoard;

    public void updateGame() {
        if (this.isDecisionValid()) {
            this.overwritePreviousBoardWithCurrentBoard();
            this.drawACircleOnTheBoard();
            this.overwritePreviousBoardWithCurrentBoard();
        } else {
            this.restoreTheBoardToPreviousState();
        }
    }

    private boolean isDecisionValid() {
        List<Byte> indexesOfBoardsFieldsWithDifferences = new ArrayList<>();
        for (byte i = 0; i < this.currentBoard.size(); i++) {
            if (!this.currentBoard.get(i).equalsIgnoreCase(this.previousBoard.get(i))) {
                indexesOfBoardsFieldsWithDifferences.add(i);
            }
        }
        if (indexesOfBoardsFieldsWithDifferences.size() != 1) {
            return false;
        } else {
            int indexOfBoardsFieldWithDifference = indexesOfBoardsFieldsWithDifferences.get(0);
            String previousField = this.previousBoard.get(indexOfBoardsFieldWithDifference);
            String currentField = this.currentBoard.get(indexOfBoardsFieldWithDifference);
            return previousField.isEmpty() && currentField.equalsIgnoreCase("X");
        }
    }

    private void overwritePreviousBoardWithCurrentBoard() {
        for (byte i = 0; i < this.currentBoard.size(); i++) {
            this.previousBoard.set(i, this.currentBoard.get(i));
        }
    }

    private void drawACircleOnTheBoard() {
        List<Byte> indexesOfBoardEmptyFields = new ArrayList<>();
        for (byte i = 0; i < this.currentBoard.size(); i++) {
            if (this.currentBoard.get(i).isEmpty()) {
                indexesOfBoardEmptyFields.add(i);
            }
        }
        byte index = indexesOfBoardEmptyFields.get(new Random().nextInt(indexesOfBoardEmptyFields.size()));
        this.currentBoard.set(index, "O");
    }

    private void restoreTheBoardToPreviousState() {
        for (byte i = 0; i < this.currentBoard.size(); i++) {
            this.currentBoard.set(i, this.previousBoard.get(i));
        }
    }

    private void checkVictoryCondition() {

    }

    private boolean isVictorious() {
        return false;
    }
}
