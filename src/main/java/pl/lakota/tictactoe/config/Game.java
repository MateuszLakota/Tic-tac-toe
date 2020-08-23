package pl.lakota.tictactoe.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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

    /**
     * @return - "X", "O" or null.
     */
    public String getWinner() {
        var listOfLists = new ArrayList<List<String>>();
        listOfLists.add(currentBoard.subList(0, 3));
        listOfLists.add(currentBoard.subList(3, 6));
        listOfLists.add(currentBoard.subList(6, 9));
        listOfLists.add(getColumn(0));
        listOfLists.add(getColumn(1));
        listOfLists.add(getColumn(2));
        listOfLists.add(getDiagonalList(true));
        listOfLists.add(getDiagonalList(false));

        var result = listOfLists.stream().filter(list -> list.stream().
                allMatch(elt -> !elt.equals("") && elt.equals(list.get(0)))).collect(Collectors.toList());
        if (result.size() > 0) {
            return result.get(0).get(0);
        }
        return null;
    }

    private List<String> getColumn(int index) {
        var column = new ArrayList<String>();
        column.add(currentBoard.get(index));
        column.add(currentBoard.get(index + 3));
        column.add(currentBoard.get(index + 6));
        return column;
    }

    private List<String> getDiagonalList(boolean fromUpperLeft) {
        var list = new ArrayList<String>();
        if (fromUpperLeft) {
            list.add(this.currentBoard.get(0));
            list.add(this.currentBoard.get(4));
            list.add(this.currentBoard.get(8));
        } else {
            list.add(this.currentBoard.get(2));
            list.add(this.currentBoard.get(4));
            list.add(this.currentBoard.get(6));
        }
        return list;
    }

    public boolean shouldElementBeReadonly(byte index) {
        return !this.currentBoard.get(index).isBlank();
    }
}
