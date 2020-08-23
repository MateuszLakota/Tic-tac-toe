package pl.lakota.tictactoe.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.lakota.tictactoe.config.Game;

import java.util.ArrayList;

@org.springframework.stereotype.Controller
public class Controller {

    private static final String GAME_PAGE = "game-page";
    private static final String FINAL_PAGE = "final-page";

    @GetMapping("/")
    public String getGamePage(Model model) {
        model.addAttribute("game", new Game(getArrayList(), getArrayList()));
        return GAME_PAGE;
    }

    private ArrayList<String> getArrayList() {
        var list = new ArrayList<String>();
        for (int i = 0; i < 9; i++) {
            list.add("");
        }
        return list;
    }

    @PostMapping("/handleDecision")
    public String handleDecision(@ModelAttribute("game") Game game, Model model) {
        game.updateGame();
        var winner = game.getWinner();
        if (winner != null) {
            var communicate = winner.equals("X") ? "Player wins." : "Computer wins.";
            model.addAttribute("communicate", communicate);
            return FINAL_PAGE;
        } else {
            model.addAttribute("game", game);
            return GAME_PAGE;
        }
    }
}