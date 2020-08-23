package pl.lakota.tictactoe.integration;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.lakota.tictactoe.config.Game;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @PostMapping("/integration")
    public Game sendRequestAndReceiveResponse(@RequestBody Game game) {
        game.updateGame();
        return game;
    }
}
