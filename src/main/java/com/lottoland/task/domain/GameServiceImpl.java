package com.lottoland.task.domain;

import com.lottoland.task.domain.player.Player;

import static com.lottoland.task.domain.Choice.*;

public class GameServiceImpl implements GameService {

    private final Player firstPlayer;
    private final Player secondPlayer;
    private final Accumulator accumulator;

    public GameServiceImpl(Player firstPlayer, Player secondPlayer, Accumulator accumulator) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.accumulator = accumulator;
    }

    @Override
    public Totals getTotals() {
        return accumulator.getTotals();
    }

    @Override
    public RoundResult playRound() {
        var player1Choice = firstPlayer.selectChoice();
        var player2Choice = secondPlayer.selectChoice();
        var result = calculateRoundResult(player1Choice, player2Choice);
        accumulator.add(result);
        return new RoundResult(player1Choice, player2Choice, result);
    }

    private Result calculateRoundResult(Choice player1Choice, Choice player2Choice) {
        if (player1Choice.equals(player2Choice)) {
            return Result.DRAW;
        } else if (player1Choice.equals(PAPER) && player2Choice.equals(ROCK) ||
                player1Choice.equals(ROCK) && player2Choice.equals(SCISSORS) ||
                player1Choice.equals(SCISSORS) && player2Choice.equals(PAPER)) {
            return Result.PLAYER_1_WINS;
        } else {
            return Result.PLAYER_2_WINS;
        }
    }

}
