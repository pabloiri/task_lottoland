package com.lottoland.task.domain;

import org.springframework.stereotype.Component;

@Component
public class Accumulator {

    private long totalRounds;
    private long totalWinsFirstPlayer;
    private long totalWinsSecondPlayer;
    private long totalDraws;

    public synchronized void add(Result result) {
        if (result.equals(Result.DRAW)) {
            totalDraws++;
        } else if (result.equals(Result.PLAYER_1_WINS)) {
            totalWinsFirstPlayer++;
        } else {
            totalWinsSecondPlayer++;
        }
        totalRounds++;
    }

    public synchronized Totals getTotals() {
        return new Totals(totalRounds, totalWinsFirstPlayer, totalWinsSecondPlayer, totalDraws);
    }
}
