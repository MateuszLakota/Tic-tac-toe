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
        model.addAttribute("game", new Game(new ArrayList<>(), new ArrayList<>()));
        return GAME_PAGE;
    }

    @PostMapping("/handleDecision")
    public String handleDecision(@ModelAttribute("game") Game game, Model model) {
        game.updateGame();
        model.addAttribute("game", game);
        return GAME_PAGE;
    }
}