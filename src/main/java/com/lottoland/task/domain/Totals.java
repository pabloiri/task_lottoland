package com.lottoland.task.domain;

public class Totals {

    private final long totalRounds;
    private final long totalWinsFirstPlayer;
    private final long totalWinsSecondPlayer;
    private final long totalDraws;

    public Totals(long totalRounds, long totalWinsFirstPlayer, long totalWinsSecondPlayer, long totalDraws) {
        this.totalRounds = totalRounds;
        this.totalWinsFirstPlayer = totalWinsFirstPlayer;
        this.totalWinsSecondPlayer = totalWinsSecondPlayer;
        this.totalDraws = totalDraws;
    }

    public long getTotalRounds() {
        return totalRounds;
    }

    public long getTotalWinsFirstPlayer() {
        return totalWinsFirstPlayer;
    }

    public long getTotalWinsSecondPlayer() {
        return totalWinsSecondPlayer;
    }

    public long getTotalDraws() {
        return totalDraws;
    }
}
