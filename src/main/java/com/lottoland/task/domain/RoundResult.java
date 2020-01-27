package com.lottoland.task.domain;

public class RoundResult {

    private final Choice firstPlayer;
    private final Choice secondPlayer;
    private final Result result;

    public RoundResult(Choice firstPlayerChoice, Choice secondPlayerChoice, Result result) {
        this.firstPlayer = firstPlayerChoice;
        this.secondPlayer = secondPlayerChoice;
        this.result = result;
    }

    public Choice getFirstPlayer() {
        return firstPlayer;
    }

    public Choice getSecondPlayer() {
        return secondPlayer;
    }

    public Result getResult() {
        return result;
    }
}
