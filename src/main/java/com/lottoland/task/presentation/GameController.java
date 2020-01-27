package com.lottoland.task.presentation;

import com.lottoland.task.domain.GameService;
import com.lottoland.task.domain.Result;
import com.lottoland.task.domain.RoundResult;
import com.lottoland.task.domain.Totals;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @RequestMapping(value = { "/play" }, method = RequestMethod.POST, produces = "application/json")
    public RoundResultDto playRound() {
        return toRoundResultDto(gameService.playRound());
    }

    @RequestMapping(value = { "/totals" }, method = RequestMethod.GET, produces = "application/json")
    public Totals totals() {
        return gameService.getTotals();
    }

    private RoundResultDto toRoundResultDto(RoundResult roundResult) {
        var result = roundResult.getResult();
        var resultValue = "draw";
        if(result == Result.PLAYER_1_WINS) {
            resultValue = "player 1 wins";
        }
        else if(result == Result.PLAYER_2_WINS) {
            resultValue = "player 2 wins";
        }
        return new RoundResultDto(roundResult.getFirstPlayer().name(), roundResult.getSecondPlayer().name(), resultValue);
    }


}