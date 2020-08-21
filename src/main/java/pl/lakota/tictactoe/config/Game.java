package pl.lakota.tictactoe.config;

import lombok.Getter;
import lombok.Setter;

public class Game {
    @Getter
    @Setter
    private Boolean upperLeft;

    @Getter
    @Setter
    private Boolean upperMiddle;

    @Getter
    @Setter
    private Boolean upperRight;

    @Getter
    @Setter
    private Boolean middleLeft;

    @Getter
    @Setter
    private Boolean middle;

    @Getter
    @Setter
    private Boolean middleRight;

    @Getter
    @Setter
    private Boolean lowerLeft;

    @Getter
    @Setter
    private Boolean lowerMiddle;

    @Getter
    @Setter
    private Boolean lowerRight;
}
