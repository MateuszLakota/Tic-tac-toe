package pl.lakota.tictactoe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.lakota.tictactoe.config.Game;

import java.util.ArrayList;
import java.util.Random;

@org.springframework.stereotype.Controller
public class Controller {

    //private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);
    private static final String GAME_PAGE = "game-page";

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